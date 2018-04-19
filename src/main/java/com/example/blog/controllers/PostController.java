package com.example.blog.controllers;


import com.example.blog.models.Post;
import com.example.blog.repositories.PostRepository;
import com.example.blog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class PostController {

    private PostService postSvc;
    private PostRepository postRepo;

    public PostController(PostService postSvc, PostRepository postRepo) {
        this.postSvc = postSvc;
        this.postRepo = postRepo;
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
    public String handleEdit(@ModelAttribute Post post){
        postRepo.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/create")
    public String create(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String create(@ModelAttribute Post post){
      postRepo.save(post);
      return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/delete")
    public String delete(@PathVariable long id, @ModelAttribute Post post){
        post = postRepo.findById(id);
        postRepo.delete(post);
        return "redirect:/posts";
    }

}
