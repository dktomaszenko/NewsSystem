package com.newssystem.server.NewsSystem.config;


import com.mongodb.Mongo;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("com.newssystem.server.NewsSystem.repository")
public class DatabaseConfiguration extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return null;
    }

    @Override
    public Mongo mongo() throws Exception {
        return null;
    }
}
