package com.newssystem.server.NewsSystem.rest;


import com.newssystem.server.NewsSystem.domain.Comment;
import com.newssystem.server.NewsSystem.domain.News;
import com.newssystem.server.NewsSystem.service.CommentService;
import com.newssystem.server.NewsSystem.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/news")
public class AppRESTController {

    private final CommentService commentService;
    private final NewsService newsService;
    private final Map<String, Object> response = new LinkedHashMap<>();

    @Autowired
    public AppRESTController(CommentService commentService, NewsService newsService) {
        this.commentService = commentService;
        this.newsService = newsService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getNews")
    public @ResponseBody
    List<News> findAll() {
        return newsService.getObj();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveNews")
    ResponseEntity<?> create(@Valid @RequestBody News newsEntity, BindingResult bindingResult) {

        if (checkError(bindingResult)) {
            newsService.create(newsEntity);
            return new ResponseEntity<>(newsEntity, HttpStatus.OK);
        } else {
            /*response se esta creando dentro del método checkError*/
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveComment")
    public @ResponseBody
    Map<String, Object> create(@Valid @RequestBody Comment commentEntity, BindingResult bindingResult) {
        if (checkError(bindingResult)) {
            commentService.create(commentEntity);

            response.clear();
            response.put("message", "Comment created succesfully");
            response.put("comment", commentService.create(commentEntity));
        }

        return response;

    }

    public boolean checkError(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            List<FieldError> errors = bindingResult.getFieldErrors();
            response.clear();
            response.put("message", "Error");

            for (FieldError error : errors) {
                response.put(error.getField(), error.getDefaultMessage());
            }
            return false;

        } else {
            return true;
        }
    }
}
