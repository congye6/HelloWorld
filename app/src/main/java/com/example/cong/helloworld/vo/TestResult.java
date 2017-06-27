package com.example.cong.helloworld.vo;

/**
 * Created by cong on 2017-06-27.
 */

public class TestResult {


    /**
     * testResult:{
     git_url:"xxx.git",
     compile_succeeded:true,
     tested:true,
     testcases:[
     name:"test1",
     passed:true
     ]
     },
     */
    public String git_url;
    public String compile_succeeded;
    public String tested;
    public TestCase[] testCases;

    public String getGit_url() {
        return git_url;
    }

    public void setGit_url(String git_url) {
        this.git_url = git_url;
    }

    public String getCompile_succeeded() {
        return compile_succeeded;
    }

    public void setCompile_succeeded(String compile_succeeded) {
        this.compile_succeeded = compile_succeeded;
    }

    public String getTested() {
        return tested;
    }

    public void setTested(String tested) {
        this.tested = tested;
    }

    public TestCase[] getTestCases() {
        return testCases;
    }

    public void setTestCases(TestCase[] testCases) {
        this.testCases = testCases;
    }

    class TestCase{
        public String name;
        public String passed;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassed() {
            return passed;
        }

        public void setPassed(String passed) {
            this.passed = passed;
        }
    }

}
