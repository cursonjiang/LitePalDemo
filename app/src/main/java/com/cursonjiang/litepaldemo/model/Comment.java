package com.cursonjiang.litepaldemo.model;

import org.litepal.crud.DataSupport;

import java.util.Date;

/**
 * Created by Administrator on 6/26 0026.
 */
public class Comment extends DataSupport{

    //多对一   多个Comment对一个News
    private News news;

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    private int id;

    private String content;

    private Date publishDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
}
