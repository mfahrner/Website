package com.theironyard.charlotte.entities;

import javax.persistence.*;

/**
 * Created by mfahrner on 9/25/16.
 */

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String date;

    @Column(nullable = false)
    String text;

    public Post() {
    }

    public Post(String date, String text) {
        this.date = date;
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
