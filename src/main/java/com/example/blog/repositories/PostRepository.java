package com.example.blog.repositories;


import com.example.blog.models.Post;
import com.example.blog.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    Iterable<Post> findByUser(User user);

    public Post findById(long id);

}
