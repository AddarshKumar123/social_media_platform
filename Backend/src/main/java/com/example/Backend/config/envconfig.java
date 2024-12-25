package com.example.Backend.config;

import org.springframework.context.annotation.Configuration;

import io.github.cdimascio.dotenv.Dotenv;

@Configuration
public class envconfig {
    static{
        Dotenv dotenv=Dotenv.load();
        System.setProperty("spring.data.mongodb.uri",dotenv.get("MONGO_URI"));
    }
}
