package com.newssystem.server.NewsSystem.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Document
public class News {

    @Id
    private String id;

    @NotNull(message = "el campo no puede estar vacío")
    @Size(min = 5, max = 70, message = "minimo 5 caracteres, maximo 70 caracteres")
    private String title;

    @NotNull
    @Size(min = 5, message = "minimo 5 caracteres")
    private String text;


    private String data;

    @NotNull
    @Size(min = 1, message = "minimo 1 caracter")
    private String author;

    public News() {}

    public News(String title, String text, String data, String author) {
        this.title = title;
        this.text = text;
        this.data = data;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
