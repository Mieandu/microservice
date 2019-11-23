package com.mieandu.contentservice.config;

import org.springframework.stereotype.Component;

@Component
public class ContentConfig {

    /**
     * 默认属性
     */
    //@Value("${example.property}")
    private String exampleProperty;

    public String getExampleProperty() {
        return exampleProperty;
    }

}
