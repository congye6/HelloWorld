package com.example.cong.helloworld.vo;

/**
 * Created by cong on 2017-06-27.
 */

public class QuestionResult {

    public QuestionInfo[] questionResults;

    public int studentId;

    public int assignmentId;

    public QuestionInfo[] getQuestionResults() {
        return questionResults;
    }

    public void setQuestionResults(QuestionInfo[] questionResults) {
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


    class QuetionInfo{
        public int questionId;
        public String questionTitle;
        public ScoreResult scoreResult;

        public MetricData metricData;

        public TestResult testResult;

        public int getQuestionId() {
            return questionId;
        }

        public void setQuestionId(int questionId) {
            this.questionId = questionId;
        }

        public String getQuestionTitle() {
            return questionTitle;
        }

        public void setQuestionTitle(String questionTitle) {
            this.questionTitle = questionTitle;
        }

        public ScoreResult getScoreResult() {
            return scoreResult;
        }

        public void setScoreResult(ScoreResult scoreResult) {
            this.scoreResult = scoreResult;
        }

        public MetricData getMetricData() {
            return metricData;
        }

        public void setMetricData(MetricData metricData) {
            this.metricData = metricData;
        }

        public TestResult getTestResult() {
            return testResult;
        }

        public void setTestResult(TestResult testResult) {
            this.testResult = testResult;
        }
    }

}

