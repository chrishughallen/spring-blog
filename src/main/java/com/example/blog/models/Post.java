package com.example.blog.models;


import javax.persistence.*;


@Entity
@Table(name="posts")
public class Post {


    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 10000)
    private String body;

    @Column(nullable = false)
    private String cat;

//    creates the relationship to the users table
    @OneToOne
    private User user;




    public Post() {
    }

    public Post(String title, String body, String cat, User user) {
        this.title = title;
        this.body = body;
        this.cat = cat;
        this.user = user;
    }

    public Post(long id, String title, String body, String cat, User user) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.cat = cat;
        this.user = user;
    }


    public String getCat() { return cat; }

    public void setCat(String cat) { this.cat = cat; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getBody() { return body; }

    public void setBody(String body) { this.body = body; }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }


    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }
}
