package com.mieandu.contentservice.clients;


import com.mieandu.contentservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("userservice")
public interface UserFeignClient {
    @RequestMapping(method = RequestMethod.GET, value = "v1/user/{username}", consumes = "application/json")
    User getUser(@PathVariable("username") String username);
}
