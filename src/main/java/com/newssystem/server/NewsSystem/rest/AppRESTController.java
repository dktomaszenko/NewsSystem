package com.newssystem.server.NewsSystem.rest;


import com.newssystem.server.NewsSystem.domain.Comment;
import com.newssystem.server.NewsSystem.domain.News;
import com.newssystem.server.NewsSystem.service.CommentService;
import com.newssystem.server.NewsSystem.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(method = RequestMethod.GET, value = "/getComments")
    public @ResponseBody List<Comment> findAllComment(){
        return commentService.getObj();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveNews")
    public @ResponseBody Map<String, Object> create(@RequestBody News newsEntity){

        newsService.create(newsEntity);
        Map<String, Object> response = new LinkedHashMap<>();

        response.put("message", "News created succesfully");
        response.put("news", newsService.create(newsEntity));

        return response;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveComment")
    public @ResponseBody Comment create(@RequestBody Comment commentEntity){
        return commentService.create(commentEntity);
    }
}
