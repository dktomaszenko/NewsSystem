package com.newssystem.server.NewsSystem.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Document
public class Comment {

    @Id
    public String id;

    @NotNull(message = "falta NewsId")
    public String NewsId;

    @NotNull(message = "no puede ser vacio")
    @Size(min = 5, max = 2000, message = "de 5 a 2000")
    public String comment;

    @NotNull(message = "no puede ser vacio")
    @Size(min = 2, max = 20, message = "de 2 a 20")
    public String author;


    public String data;

    public Comment(){}

    public Comment(String newsId, String comment, String author, String data) {
        NewsId = newsId;
        this.comment = comment;
        this.author = author;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNewsId() {
        return NewsId;
    }

    public void setNewsId(String newsId) {
        NewsId = newsId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
