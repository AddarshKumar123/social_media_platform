package com.example.Backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Backend.model.Usermodel;

public interface Userrepository extends MongoRepository<Usermodel,String> {
    Usermodel findByUserName(String username);

}
