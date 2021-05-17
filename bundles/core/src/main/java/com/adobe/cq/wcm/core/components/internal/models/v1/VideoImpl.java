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
