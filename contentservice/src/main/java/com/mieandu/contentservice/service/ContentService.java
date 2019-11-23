package com.mieandu.contentservice.service;

import com.mieandu.contentservice.clients.UserDiscoveryClient;
import com.mieandu.contentservice.clients.UserFeignClient;
import com.mieandu.contentservice.clients.UserRestTemplateClient;
import com.mieandu.contentservice.model.Article;
import com.mieandu.contentservice.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class ContentService {
    @Autowired
    UserDiscoveryClient userDiscoveryClient;
    @Autowired
    UserFeignClient userFeignClient;
    @Autowired
    UserRestTemplateClient userRestTemplateClient;
    @Autowired
    RestTemplate restTemplate;

    /**
     * HystrixCommand必须放第一个调用方法，不然不会生效
     *
     * @param articleId
     * @param clientType
     * @return
     */
    @HystrixCommand(fallbackMethod = "buildFallbackGetUser", commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")})
    public Article getArticle(String articleId, String clientType) {
        if (!articleId.endsWith("1")) {
            return null;
        }
        Article article = new Article();
        article.setArticleId("1");
        article.setTitle("再别康桥");
        article.setContent("轻轻的我走了。。。");
        User user = retriveUser("徐志摩", clientType);
        article.setUsername(user.getUsername());
        return article;
    }


    private User retriveUser(String username, String clientType) {
       /* try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        switch (clientType) {
            case "feign":
                return userFeignClient.getUser(username);
            case "rest":
                return userRestTemplateClient.getUser(username);
            case "discovery":
                return userDiscoveryClient.getUser(username);
        }

        return null;
    }


    /**
     * 后备方法
     *
     * @param username
     * @param clientType
     * @return
     */
    public Article buildFallbackGetUser(String username, String clientType) {
        Article article = new Article();
        article.setArticleId("1");
        article.setTitle("再别康桥");
        article.setContent("轻轻的我走了。。。");
        article.setUsername("后背姓名");
        return article;
    }

    @HystrixCommand(fallbackMethod = "reliable", commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")})
    public String readingList(String username) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        URI uri = URI.create("http://localhost:8090/recommended");
        return this.restTemplate.getForObject(uri, String.class);
    }

    public String reliable(String username) {
        //User user = userFeignClient.getUser(username);
        //System.out.println("调用后备模式成功" + user.getUsername());
        return "匿名";
    }
}
