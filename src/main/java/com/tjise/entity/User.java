package com.tjise.entity;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private String pwd;

    private int score;

    public User(int id, String name, String pwd, int score) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.score = score;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
