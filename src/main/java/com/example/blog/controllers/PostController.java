package com.example.blog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller

public class PostController {
    @GetMapping("/posts")
    public String index(Model model){
        List<Post> posts = new ArrayList<>();
        Post post1 = new Post();
        Post post2 = new Post();
        posts.add(post1);
        posts.add(post2);
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable int id, Model model){
        Post post = new Post();
        model.addAttribute("title", post.getTitle());
        model.addAttribute("body", post.getBody());
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String create(){
        return "post creation form...";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String insert(){
        return "Inserted new post.";
    }

}
