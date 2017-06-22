package com.example.cong.helloworld.Controller;

import android.content.Context;

import com.example.cong.helloworld.Activity.SampleApplication;
import com.example.cong.helloworld.R;
import com.example.cong.helloworld.Tool.HttpGetTask;
import com.example.cong.helloworld.vo.StudentClass;
import com.google.gson.Gson;

import layout.StudentListFragment;

/**
 * Created by cong on 2017-06-02.
 */

public class StudentListController implements HttpCallBackService{


    private StudentListFragment fragment;



    public StudentListController(StudentListFragment fragment) {
        this.fragment = fragment;
    }

    public void getStudentList(){
        Context context= SampleApplication.getContext();
        String url=context.getString(R.string.base_url)+context.getString(R.string.student_list_path);
        HttpGetTask get=new HttpGetTask(this);
        get.execute(url);
    }

    @Override
    public void callback(String json) {
        Gson gson=new Gson();
        System.out.println("get classes json:"+json);
        StudentClass[] classes=gson.fromJson(json,StudentClass[].class);
        fragment.initClassList(classes);
    }
}
