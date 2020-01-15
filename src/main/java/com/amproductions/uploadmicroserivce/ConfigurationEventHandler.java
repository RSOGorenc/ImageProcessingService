package com.amproductions.uploadmicroserivce;

import com.kumuluz.ee.configuration.utils.ConfigurationUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import java.util.logging.Logger;


@ApplicationScoped
public class ConfigurationEventHandler {

    private static final Logger log = Logger.getLogger(ConfigurationEventHandler.class.getName());

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {

        String watchedKey = "rest-config.maintenance";

        ConfigurationUtil.getInstance().subscribe(watchedKey, (String key, String value) -> {

            if (watchedKey.equals(key)) {

                if ("true".equals(value.toLowerCase())) {
                    log.info("Maintenence mode enabled.");
                } else {
                    log.info("Maintenence mode disabled.");
                }

            }

        });
    }

}
