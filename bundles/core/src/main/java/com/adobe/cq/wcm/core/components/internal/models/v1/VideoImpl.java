/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 ~ Copyright 2017 Adobe
 ~
 ~ Licensed under the Apache License, Version 2.0 (the "License");
 ~ you may not use this file except in compliance with the License.
 ~ You may obtain a copy of the License at
 ~
 ~     http://www.apache.org/licenses/LICENSE-2.0
 ~
 ~ Unless required by applicable law or agreed to in writing, software
 ~ distributed under the License is distributed on an "AS IS" BASIS,
 ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 ~ See the License for the specific language governing permissions and
 ~ limitations under the License.
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
package com.adobe.cq.wcm.core.components.internal.models.v1;

import com.adobe.cq.wcm.core.components.models.Video;
import com.day.cq.commons.DownloadResource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.jetbrains.annotations.Nullable;

import javax.annotation.PostConstruct;

public class VideoImpl extends AbstractComponentImpl implements Video {

    @ValueMapValue(name = DownloadResource.PN_REFERENCE, injectionStrategy = InjectionStrategy.OPTIONAL)
    @Nullable
    private String fileReference;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    @Nullable
    private String posterImageReference;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    @Default(booleanValues = false)
    private boolean hideControl;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    @Default(booleanValues = false)
    private boolean loopEnabled;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    @Default(booleanValues = false)
    private boolean autoplayEnabled;

    /**
     * The current resource properties.
     */
    @ScriptVariable
    protected ValueMap properties;

    /**
     * Initialize the model.
     */
    @PostConstruct
    private void initModel() {
        posterImageReference = properties.get(Video.PN_POSTER_REFERENCE, posterImageReference);
        hideControl = properties.get(Video.PN_HIDE_CONTROL, hideControl);
        loopEnabled = properties.get(Video.PN_LOOP_ENABLED, loopEnabled);
        autoplayEnabled = properties.get(Video.PN_AUTOPLAY_ENABLED, autoplayEnabled);
    }

    @Override
    public String getFileReference() {
        return fileReference;
    }

    @Override
    public String getPosterImageReference() {
        return posterImageReference;
    }

    @Override
    public boolean isHideControl() {
        return hideControl;
    }

    @Override
    public boolean isLoopEnabled() {
        return loopEnabled;
    }

    @Override
    public boolean isAutoplayEnabled() {
        return autoplayEnabled;
    }

}
