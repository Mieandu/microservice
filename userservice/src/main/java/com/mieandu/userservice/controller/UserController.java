package com.mieandu.userservice.controller;

import com.mieandu.userservice.config.UserConfig;
import com.mieandu.userservice.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/user")
@Slf4j
public class UserController {

    @Autowired
    private UserConfig userConfig;

    @RequestMapping(value = "{username}")
    public User getUser(@PathVariable(value = "username") String ussername) {
        log.info("用户名：{} 配置{}：", ussername, userConfig.getExampleProperty());
        User user = new User();
        user.setUsername(ussername);
        return user;
    }

    @RequestMapping(value = "save/{username}")
    public User saveUser(@PathVariable(value = "username") String ussername) {
        log.info("配置：" + userConfig.getExampleProperty());
        User user = new User();
        user.setUsername(ussername);
        return user;
    }
}
