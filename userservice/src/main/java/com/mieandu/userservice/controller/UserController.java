package com.mieandu.userservice.controller;

import com.mieandu.userservice.config.UserConfig;
import com.mieandu.userservice.model.User;
import com.mieandu.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "v1/user")
@Slf4j
public class UserController {

    @Autowired
    private UserConfig userConfig;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "{username}")
    public User getUser(@PathVariable(value = "username") String ussername) {
        log.info("用户名：{} 配置{}：", ussername, userConfig.getExampleProperty());
        User user = new User();
        user.setUserName(ussername);
        return user;
    }

    @RequestMapping(value = "save")
    public User saveUser(@RequestBody @Validated User user) {
        userService.saveUser(user);
        return user;
    }

    @RequestMapping(value = "list")
    public List<User> listUser() {
        return userService.listUsers();
    }

    @RequestMapping(value = "getConfig")
    public String getConfig() {
        log.info("配置：" + userConfig.getExampleProperty());
        return  userConfig.getExampleProperty();
    }
}
