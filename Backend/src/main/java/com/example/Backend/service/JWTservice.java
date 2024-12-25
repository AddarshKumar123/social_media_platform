package com.example.Backend.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTservice {

    private String secretKey="9a4f2c8d3b7a1e6f45c8a0b3f267d8b1d4e6f3c8a9d2b5f8e3a9c8b5f6v8a3d9";

    private Key getKey(){
        byte[] byteVal=secretKey.getBytes();
        return Keys.hmacShaKeyFor(byteVal);
    }
    
    public String getJWTToken(String userName){
        Map<String,Object> claims=new HashMap<>();

        return Jwts.builder()
        .claim("username",userName)
        .addClaims(claims)
        .setSubject(userName)
        .setIssuedAt(new Date())
        .signWith(getKey())
        .compact();
        
    }
}
