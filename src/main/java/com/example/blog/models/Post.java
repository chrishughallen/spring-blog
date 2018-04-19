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


    public Post() {
    }

    public Post(String title, String body, String cat) {
        this.title = title;
        this.body = body;
        this.cat = cat;
    }

    public Post(long id, String title, String body, String cat) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.cat = cat;
    }




    public String getCat() { return cat; }

    public void setCat(String cat) { this.cat = cat; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getBody() { return body; }

    public void setBody(String body) { this.body = body; }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

}
