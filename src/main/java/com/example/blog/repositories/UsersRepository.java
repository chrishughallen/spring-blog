package com.example.blog.repositories;

import com.example.blog.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}

