package com.mieandu.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author mandu
 * @version 1.0
 * @date 2019/3/18 17:52
 */
@SpringBootApplication
@RestController
public class GatewayServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServerApplication.class, args);
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        String httpUri = "http://httpbin.org:80";
        return builder.routes().route(p -> p.path("/get").filters(f -> f.addRequestHeader("Hello", "World")).uri(httpUri)).route(p -> p.host("*.hystrix.com").filters(f -> f.hystrix(config -> config.setName("mycmd").setFallbackUri("forward:/fallback"))).uri(httpUri)).build();
    }

    @RequestMapping("/fallback")
    public Mono<String> fallback() {
        return Mono.just("fallback");
    }

}