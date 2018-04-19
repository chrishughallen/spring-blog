package com.example.blog.models;

import javax.persistence.*;


@Entity
@Table(name="people")
public class Person {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String state_residing;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState_residing() {
        return state_residing;
    }

    public void setState_residing(String reside_state) {
        this.state_residing = reside_state;
    }
}









