package com.example.cong.helloworld.vo;

public class QuetionWrapper{
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