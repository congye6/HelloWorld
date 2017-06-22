package com.example.cong.helloworld.vo;

/**
 * Created by cong on 2017-06-12.
 */

public class Practice {
    /**
     * [
     {
     "id": 3,
     "title": "考试1",
     "description": "考试1",
     "startAt": "2017-04-25 16:22:47.0",
     "endAt": "2017-04-25 16:46:47.0",
     "questions": [

     ],
     "course": 1,
     "status":
     "newly"|          //新建态
     "initing"|        //正在初始化
     "initFail"|       //初始化失败
     "initSuccess"|    //初始化成功
     "ongoing"|        //考试正在进行
     "timeup"|         //考试时间到
     "analyzing"|      //正在分析结果
     "analyzingFinish" //结果分析完毕
     ,
     "currentTime": "2017-05-26 11:24:12"
     }
     ]
     */
    public String id;
    public String title;
    public String description;
    public String startAt;
    public String endAt;
    public Question[] questions;
    public String course;
    public String status;
    public String currentTime;

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

    public String getStartAt() {
        return startAt;
    }

    public void setStartAt(String startAt) {
        this.startAt = startAt;
    }

    public String getEndAt() {
        return endAt;
    }

    public void setEndAt(String endAt) {
        this.endAt = endAt;
    }

    public Question[] getQuestions() {
        return questions;
    }

    public void setQuestions(Question[] questions) {
        this.questions = questions;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }
}
