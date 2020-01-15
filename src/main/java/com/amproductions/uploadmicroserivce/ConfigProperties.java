package com.amproductions.uploadmicroserivce;

import com.kumuluz.ee.configuration.cdi.ConfigBundle;
import com.kumuluz.ee.configuration.cdi.ConfigValue;

import javax.enterprise.context.ApplicationScoped;

/**
 * @author Benjamin Kastelic
 * @since 2.3.0
 */
@ApplicationScoped
@ConfigBundle("size-config")
public class ConfigProperties {

    @ConfigValue(watch = true)
    private Integer width;
    @ConfigValue(watch = true)
    private  Integer height;

    public Integer getHeight() {
        return height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }
}
