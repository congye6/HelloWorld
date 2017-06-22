package com.example.cong.helloworld.vo;

/**
 * Created by cong on 2017-06-12.
 */


public class Question {
    /**
     * {
     "id": 1,
     "title": "题目1",
     "description": "题目1",
     "difficulty": "3",
     "gitUrl": "http://115.29.184.56:10080/kenny67nju/Homework12-Curriculum.git",
     "type": "exam",
     "creator": {
     "id": 1,
     "username": "liuqin",
     "name": "刘钦",
     "type": "teacher",
     "avatar": null,
     "gender": "male",
     "email": "lq@nju.edu.cn",
     "schoolId": 1
     },
     "duration": 0,
     "link": -1,
     "knowledgeVos": null
     }
     */
    public String id;
    public String title;
    public String description;
    public String difficulty;
    public String gitUrl;
    public String type;
    public User creator;
    public String duration;
    public String link;
    public String knowledgeVos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public void setGitUrl(String gitUrl) {
        this.gitUrl = gitUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getKnowledgeVos() {
        return knowledgeVos;
    }

    public void setKnowledgeVos(String knowledgeVos) {
        this.knowledgeVos = knowledgeVos;
    }
}
