package com.newssystem.server.NewsSystem.repository;


import com.newssystem.server.NewsSystem.domain.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {
}
