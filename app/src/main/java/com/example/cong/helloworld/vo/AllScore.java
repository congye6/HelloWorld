package com.example.cong.helloworld.vo;

/**
 * Created by cong on 2017-06-21.
 */

public class AllScore {

    public QuestionInfo questionInfo;

    public StudentScore[] students;

    public QuestionInfo getQuestionInfo() {
        return questionInfo;
    }

    public void setQuestionInfo(QuestionInfo questionInfo) {
        this.questionInfo = questionInfo;
    }

    public StudentScore[] getStudents() {
        return students;
    }

    public void setStudents(StudentScore[] students) {
        this.students = students;
    }
}
