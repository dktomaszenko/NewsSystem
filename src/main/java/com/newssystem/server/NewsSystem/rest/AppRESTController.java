package com.newssystem.server.NewsSystem.rest;


import com.newssystem.server.NewsSystem.domain.News;
import com.newssystem.server.NewsSystem.service.CommentService;
import com.newssystem.server.NewsSystem.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class AppRESTController {

    private final CommentService commentService;
    private final NewsService newsService;

    @Autowired
    public AppRESTController(CommentService commentService, NewsService newsService) {
        this.commentService = commentService;
        this.newsService = newsService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getNews")
    public @ResponseBody
    List<News> findAll(){
        return newsService.getObj();
    }
}
