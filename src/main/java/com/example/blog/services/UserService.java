package com.example.blog.services;

import com.example.blog.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    public boolean isOwner(long id){
        User user =  (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user.getId() == id){
            return true;
        }
        return false;
    }

    public boolean isLoggedIn(){
        User user =  (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user != null;
    }

    public User currentUser(){
      User user =  (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      return user;
    }
}


