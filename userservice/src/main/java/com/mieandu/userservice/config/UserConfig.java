package com.mieandu.userservice.config;

import org.springframework.stereotype.Component;

@Component
public class UserConfig {

    /**
     * 默认属性
     */
    //@Value("${example.property}")
    private String exampleProperty;

    public String getExampleProperty() {
        return exampleProperty;
    }

}
