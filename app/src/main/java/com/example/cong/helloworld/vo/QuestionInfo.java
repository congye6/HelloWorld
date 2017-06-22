package com.example.cong.helloworld.vo;

/**
 * Created by cong on 2017-06-21.
 */

public class QuestionInfo {

    /**
     * questionInfo:{
     id: 1,
     title: "题目1",
     description: "xxxxx",
     type: "exam"
     }
     */
    public int id;
    public String title;
    public String description;
    public String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
