package com.example.cong.helloworld.Controller;

import android.content.Context;

import com.example.cong.helloworld.Activity.SampleApplication;
import com.example.cong.helloworld.R;
import com.example.cong.helloworld.Tool.HttpGetTask;

import layout.StudentScoreStatisticFragment;

/**
 * Created by cong on 2017-06-27.
 * 学生某次考试的统计分析
 */

public class StudentScoreController implements HttpCallBackService{

    private StudentScoreStatisticFragment fragment;

    public StudentScoreController(StudentScoreStatisticFragment fragment) {
        this.fragment = fragment;
    }


    public void getStudentScore(int assignmentId,int studentId){
        Context context= SampleApplication.getContext();
        String url=context.getString(R.string.base_url)+context.getString(R.string.assignment)+"/"+assignmentId+
                "/student/"+studentId+"/analysis";
        HttpGetTask getTask=new HttpGetTask(this);
        getTask.execute(url);
    }

    @Override
    public void callback(String json) {
        System.out.println("get student score json:"+json);
    }
}
