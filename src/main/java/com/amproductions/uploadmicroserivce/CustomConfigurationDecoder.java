package com.amproductions.uploadmicroserivce;

import com.kumuluz.ee.configuration.ConfigurationDecoder;

import javax.xml.bind.DatatypeConverter;

public class CustomConfigurationDecoder implements ConfigurationDecoder {

    @Override
    public boolean shouldDecode(String key) {
        if ("rest-config.encoded-property".equals(key)) {
            return true;
        }
        return false;
    }

    @Override
    public String decode(String key, String value) {
        return new String(DatatypeConverter.parseBase64Binary(value));
    }
}
