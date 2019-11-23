package com.mieandu.contentservice.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class Article {
    private String articleId;
    @NotNull
    @Length(max = 30, message = "标题长度不能超过30")
    private String title;
    private String username;
    private String content;

}
