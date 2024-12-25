package com.example.Backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Backend.model.UserPrincipal;
import com.example.Backend.model.Usermodel;
import com.example.Backend.repository.Userrepository;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private Userrepository userrepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Usermodel user=userrepository.findByUserName(username);
        if(user==null){
            throw new UsernameNotFoundException("user not found");
        }
        
        return new UserPrincipal(user);
    }

}
