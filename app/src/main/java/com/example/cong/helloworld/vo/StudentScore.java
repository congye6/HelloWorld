package com.example.cong.helloworld.vo;

/**
 * Created by cong on 2017-06-21.
 */

public class StudentScore {
    /**
     * studentId: 227,
     studentName: "",
     studentNumber: "",
     score: 100,
     scored: true
     */
    public int studentId;
    public String studentName;
    public String studentNumber;
    public double score;
    public String scored;


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getScored() {
        return scored;
    }

    public void setScored(String scored) {
        this.scored = scored;
    }
}
