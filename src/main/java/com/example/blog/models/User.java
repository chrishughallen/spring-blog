package com.example.blog.models;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    @Size (min=5, max=25, message = "Username must be between 5 and 25 characters")
    private String username;

    @Column(nullable = false, unique = true)
    @Size (min=1, message = "Email field cannot be blank")
    private String email;

    @Column(nullable = false)
    @Size (min=1, message = "Password cannot be empty")
    private String password;


//    this is to insert users
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

//    this is to get a full user object
    public User(Long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(User copy) {
        id = copy.id;
        email = copy.email;
        username = copy.username;
        password = copy.password;
    }



    public User() {
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }
}
