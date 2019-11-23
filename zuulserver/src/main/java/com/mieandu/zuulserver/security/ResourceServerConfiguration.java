package com.mieandu.zuulserver.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author mandu
 * @version 1.0
 * @date 2019/2/22 14:17
 */
@Configuration
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // 认证服务不需要通过认证，其他的需要通过权限认证
        http.
                authorizeRequests().antMatchers("/auth-server/**").permitAll().and().authorizeRequests().anyRequest().authenticated();
    }
}
