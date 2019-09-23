package com.example.rice.Entity;
/**
* 用来接收Home页面的数据
* */
public class Home_entity {
    private String name;
    private String score;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Home_entity(String name, String score, String id) {
        this.name = name;
        this.score = score;
        this.id = id;
    }
}
