package com.example.Backend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Backend.model.Usermodel;
import com.example.Backend.repository.Userrepository;

@Service
public class Userservice {
    @Autowired
    private Userrepository userrepository;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JWTservice jwTservice;

    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(10);

    public Usermodel saveUser(Usermodel user){
        user.setPassword(encoder.encode(user.getPassword()));
        return userrepository.save(user);
    }

    public String getUser(Usermodel user){
        Authentication authentication=
        authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword()));

        if(authentication.isAuthenticated()){
            return jwTservice.getJWTToken(user.getUserName());
        }

        return "No such User exist";
    }
}
