package com.example.cong.helloworld.vo;

/**
 * Created by cong on 2017-06-27.
 */

public class MetricData {
    /**
     * metricData:{
     git_url:"xxx.git",
     measured:true,
     total_line_count:158,
     comment_line_count:35,
     field_count:5,
     method_count:5,
     max_coc:2
     }
     */
    public String git_url;
    public String measured;
    public int total_line_count;
    public int comment_line_count;
    public int field_count;
    public int method_count;
    public int max_coc;

    public String getGit_url() {
        return git_url;
    }

    public void setGit_url(String git_url) {
        this.git_url = git_url;
    }

    public String getMeasured() {
        return measured;
    }

    public void setMeasured(String measured) {
        this.measured = measured;
    }

    public int getTotal_line_count() {
        return total_line_count;
    }

    public void setTotal_line_count(int total_line_count) {
        this.total_line_count = total_line_count;
    }

    public int getComment_line_count() {
        return comment_line_count;
    }

    public void setComment_line_count(int comment_line_count) {
        this.comment_line_count = comment_line_count;
    }

    public int getField_count() {
        return field_count;
    }

    public void setField_count(int field_count) {
        this.field_count = field_count;
    }

    public int getMethod_count() {
        return method_count;
    }

    public void setMethod_count(int method_count) {
        this.method_count = method_count;
    }

    public int getMax_coc() {
        return max_coc;
    }

    public void setMax_coc(int max_coc) {
        this.max_coc = max_coc;
    }
}
