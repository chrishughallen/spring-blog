package com.example.blog.models;


import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
@Table(name="posts")
public class Post {


    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    @Size(min=1, max=400, message = "Title must be between 1 and 400 characters long.")
    private String title;

    @Column(nullable = false, length = 10000)
    @Size(min = 1, message = "Body of post cannot be empty")
    private String body;

    @Column(nullable = false)
    private String cat;

    @Column(nullable = false)
    private String bg_color;

    @Column(nullable = false)
    private String font_color;

    //    creates the relationship to the users table
    @OneToOne
    private User user;








    public Post() {
    }

    public Post(String title, String body, String cat, User user, String bg_color, String font_color) {
        this.title = title;
        this.body = body;
        this.cat = cat;
        this.user = user;
        this.bg_color = bg_color;
        this.font_color = font_color;
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

    public String getFont_color() { return font_color; }

    public void setFont_color(String font_color) { this.font_color = font_color; }

    public String getBg_color() { return bg_color; }

    public void setBg_color(String bg_color) { this.bg_color = bg_color; }

}
