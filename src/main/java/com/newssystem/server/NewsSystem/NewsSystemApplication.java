package com.newssystem.server.NewsSystem;

import com.newssystem.server.NewsSystem.domain.Comment;
import com.newssystem.server.NewsSystem.domain.News;
import com.newssystem.server.NewsSystem.service.CommentService;
import com.newssystem.server.NewsSystem.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@SpringBootConfiguration
@EnableAutoConfiguration
@Configuration
@ComponentScan
public class NewsSystemApplication implements CommandLineRunner {

    @Autowired
    public NewsService newsService;

    @Autowired
    public CommentService commentService;

    public static void main(String[] args) {
        SpringApplication.run(NewsSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

/*        News obj = new News("Tytul", "Tresc", "12.09.2017");

        newsService.create(obj);

        Comment commObj = new Comment("1235689825", "comment", "author", "12.09.2017");

        commentService.create(commObj);*/
    }
}
