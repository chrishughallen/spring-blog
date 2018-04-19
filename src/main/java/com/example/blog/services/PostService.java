package com.example.blog.services;

import com.example.blog.models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PostService {

    private List<Post> posts;

    public PostService(){
        this.posts = new ArrayList<>();
    }

//    public List<Post> findAll() {
////        return posts;
////    }



    public Post findPost(long id){
        return posts.get((int)id -1);
    }

    public Post save(Post post) {
        post.setId(posts.size() + 1);
        this.posts.add(post);
        return post;
    }





}
