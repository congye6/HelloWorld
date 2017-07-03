package com.example.cong.helloworld.vo;

/**
 * Created by cong on 2017-06-27.
 */

public class QuestionResult {

    public QuetionWrapper[] questionResults;

    public int studentId;

    public int assignmentId;

    public QuetionWrapper[] getQuestionResults() {
        return questionResults;
    }

    public void setQuestionResults(QuetionWrapper[] questionResults) {
        this.questionResults = questionResults;
    }


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    /**
     * studentId:227,
     assignmentId:12,
     questionResults:[
     questionId:1,
     questionTitle:"题目1",
     scoreResult:{
     git_url:"xxx.git",
     score:100,
     scored:true
     },
     testResult:{
     git_url:"xxx.git",
     compile_succeeded:true,
     tested:true,
     testcases:[
     name:"test1",
     passed:true
     ]
     },
     metricData:{
     git_url:"xxx.git",
     measured:true,
     total_line_count:158,
     comment_line_count:35,
     field_count:5,
     method_count:5,
     max_coc:2
     }
     ]
     */




}

