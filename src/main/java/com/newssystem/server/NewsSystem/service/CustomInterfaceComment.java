package com.newssystem.server.NewsSystem.service;


import com.newssystem.server.NewsSystem.domain.Comment;

import java.util.List;

public interface CustomInterfaceComment {

    List<Comment>findByNewsId(String id);
}
