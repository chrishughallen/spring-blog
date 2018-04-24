package com.example.blog.controllers;


import com.example.blog.models.Post;
import com.example.blog.models.User;
import com.example.blog.repositories.PostRepository;
import com.example.blog.repositories.UserRepository;
import com.example.blog.services.PostService;
import org.springframework.security.core.context.SecurityContextHolder;
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

    public PostController(PostService postSvc, PostRepository postRepo, UserRepository userRepo) {
        this.postSvc = postSvc;
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("posts", postRepo.findAll());
        return "posts/index";
    }

    @GetMapping("/posts")
    public String index(Model model){
        model.addAttribute("posts", postRepo.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model model){
        model.addAttribute("post", postRepo.findById(id));
        return "posts/show";
    }

    @GetMapping("/posts/{id}/edit")
    public String edit(@PathVariable long id, Model model){
        model.addAttribute("post", postRepo.findById(id));
        return "/posts/edit";
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
      User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      post.setUser(loggedInUser);
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
