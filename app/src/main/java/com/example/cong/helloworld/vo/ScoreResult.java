package com.example.cong.helloworld.vo;

/**
 * Created by cong on 2017-06-27.
 */

public class ScoreResult {

    /**
     * scoreResult:{
     git_url:"xxx.git",
     score:100,
     scored:true
     },
     */

    public String git_url;

    public double score;

    public String scored;


    public String getGit_url() {
        return git_url;
    }

    public void setGit_url(String git_url) {
        this.git_url = git_url;
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
