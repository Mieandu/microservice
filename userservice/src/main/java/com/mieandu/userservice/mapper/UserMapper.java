package com.mieandu.userservice.mapper;

import com.mieandu.userservice.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author mandu
 * @version 1.0
 * @date 2019/8/23 14:46
 */
@Repository
public interface UserMapper {
    List<User> listUser();

    void saveUser(User user);
}
