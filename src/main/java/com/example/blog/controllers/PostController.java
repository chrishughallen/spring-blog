package com.example.blog.controllers;


import com.example.blog.models.Post;
import com.example.blog.repositories.PostRepository;
import com.example.blog.repositories.UserRepository;
import com.example.blog.services.PostService;
import com.example.blog.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller

public class PostController {

    private PostService postSvc;
    private PostRepository postRepo;
    private UserRepository userRepo;
    private UserService userSvc;

    public PostController(PostService postSvc, PostRepository postRepo, UserRepository userRepo, UserService userSvc) {
        this.postSvc = postSvc;
        this.postRepo = postRepo;
        this.userRepo = userRepo;
        this.userSvc = userSvc;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("posts", postRepo.findAll());
        return "posts/index";
    }

    @GetMapping("/posts")
    public String index(Model model){
        if(postRepo.findAll() != null) {
            model.addAttribute("posts", postRepo.findAll());
            return "posts/index";
        }
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model model){
        model.addAttribute("post", postRepo.findById(id));
        return "posts/show";
    }

    @GetMapping("/posts/{id}/edit")
    public String edit(@PathVariable long id, Model model){
        Post post = postRepo.findById(id);
        Long poster = post.getUser().getId();
        if(userSvc.currentUser().getId() == poster){
        model.addAttribute("post", postRepo.findById(id));
        return "/posts/edit";
        }
        return "redirect:/posts/" + post.getId();
    }

    @PostMapping("/posts/edit")
    public String handleEdit(@Valid Post post, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute(post);
            return"posts/edit";
        }
        postRepo.save(post);
        return "redirect:/posts/" + post.getId();
    }

    @GetMapping("/profile")
    public String viewProfile(Model model){
        if(!userSvc.isLoggedIn()){
            return "redirect:/login";
        }else if(postRepo.findByUserId(userSvc.currentUser().getId()) != null){
            model.addAttribute("posts", postRepo.findByUserId(userSvc.currentUser().getId()));
            model.addAttribute("user", userSvc.currentUser());
            return "users/profile";
        }else model.addAttribute("user", userSvc.currentUser());
        return "users/profile";
    }

    @GetMapping("/posts/create")
    public String create(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String create(@Valid Post post, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute(post);
            return"posts/create";
        }
        post.setUser(userSvc.currentUser());
      postRepo.save(post);
      return "redirect:/posts/" + post.getId();
    }


    @GetMapping("/posts/{id}/delete")
    public String delete(@PathVariable long id, @ModelAttribute Post post){
        post = postRepo.findById(id);
        postRepo.delete(post);
        return "redirect:/posts";
    }

}
