package com.example.blog.models;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;


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

    @CreationTimestamp
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;



    public Post() {
    }

    public Post(String title, String body, String cat, Date created) {
        this.title = title;
        this.body = body;
        this.cat = cat;
        this.created = created;
    }

    public Post(long id, String title, String body, String cat, Date created) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.cat = cat;
        this.created = created;
    }




    public String getCat() { return cat; }

    public void setCat(String cat) { this.cat = cat; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getBody() { return body; }

    public void setBody(String body) { this.body = body; }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public Date getCreated() { return created; }

    public void setCreated(Date created) { this.created = created; }
}
