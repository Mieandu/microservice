package com.mieandu.userservice.service;

import com.mieandu.userservice.mapper.UserMapper;
import com.mieandu.userservice.model.User;
import com.mieandu.util.IdGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mandu
 * @version 1.0
 * @date 2019/8/23 15:34
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public List<User> listUsers() {
        return userMapper.listUser();
    }

    public User saveUser(User user) {
        user.setUserId(IdGen.USER_ID.nextId());
        userMapper.saveUser(user);
        return user;
    }
}
