package com.mieandu.zuulserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * 服务网关
 *
 * @author mandu
 * @version 1.0
 * @date 2019/2/22 14:17
 */
@SpringBootApplication
@EnableZuulProxy
@EnableResourceServer
public class ZuulServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulServerApplication.class, args);
    }
}
