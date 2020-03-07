package com.ricky.example.entity;

import java.io.Serializable;

/**
 * @author ricky
 * @create 2020-03-07 16:34
 */

//注意点：索引名称记得小写，类属性名称也要小写
//@Document(indexName = "blog", type = "article")
public class Article implements Serializable {

    private static final long serivalVersionUID = 1L;

    private long id;

    private String title;

    private String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



}
