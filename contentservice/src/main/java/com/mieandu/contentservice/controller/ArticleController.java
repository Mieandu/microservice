package com.mieandu.contentservice.controller;

import com.mieandu.contentservice.config.ContentConfig;
import com.mieandu.contentservice.model.Article;
import com.mieandu.contentservice.service.ContentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/article")
@Slf4j
public class ArticleController {

    @Autowired
    private ContentConfig contentConfig;
    @Autowired
    private ContentService contentService;

    @RequestMapping(value = "{articleId}/{clientType}")
    public Article getArticle(@PathVariable(value = "articleId") String articleId, @PathVariable(value = "clientType") String clientType) {
        log.info("配置：{}", contentConfig.getExampleProperty());
        return contentService.getArticle(articleId, clientType);
    }

    @RequestMapping("/to-read")
    public String toRead() {
        return contentService.readingList("fff");
    }
}
