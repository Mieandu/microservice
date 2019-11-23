package com.mieandu.contentservice.clients;

import com.mieandu.contentservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserRestTemplateClient {

    @Autowired
    RestTemplate restTemplate;

    public User getUser(String username) {
        ResponseEntity<User> restExchange = restTemplate.exchange("http://userservice/v1/user/{username}", HttpMethod.GET, null, User.class, username);

        return restExchange.getBody();
    }
}
