package com.mieandu.userservice.config;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserConfig {

    /**
     * 默认属性
     */
    //@Value("${example.property}")
    private String exampleProperty;
}
