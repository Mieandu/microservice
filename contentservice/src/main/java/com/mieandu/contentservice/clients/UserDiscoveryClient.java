package com.mieandu.contentservice.clients;


import com.mieandu.contentservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * di
 */
@Component
public class UserDiscoveryClient {

    @Autowired
    private DiscoveryClient discoveryClient;

    public User getUser(String username) {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("userservice");

        if (instances.size() == 0) return null;
        String serviceUri = String.format("%s/v1/user/%s", instances.get(0).getUri().toString(), username);
        System.out.println("!!!! SERVICE URI:  " + serviceUri);


        ResponseEntity<User> restExchange = restTemplate.exchange(serviceUri, HttpMethod.GET, null, User.class, username);

        return restExchange.getBody();
    }
}
