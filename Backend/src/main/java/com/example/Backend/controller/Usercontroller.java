package com.example.Backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Backend.model.Usermodel;
import com.example.Backend.service.Userservice;

@RestController
public class Usercontroller {

    @Autowired
    private Userservice userservice;

    @PostMapping("/register")
    public ResponseEntity<Usermodel> createUser(@RequestBody Usermodel user){
        Usermodel createdUser=userservice.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser); 
    }

    @PostMapping("/login")
    public String getEmployee(@RequestBody Usermodel user){
        return userservice.getUser(user);
    }

}
