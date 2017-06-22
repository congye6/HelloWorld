package com.example.cong.helloworld.Controller;

import android.content.Context;

import com.example.cong.helloworld.Activity.MainActivity;
import com.example.cong.helloworld.Activity.SampleApplication;
import com.example.cong.helloworld.R;
import com.example.cong.helloworld.Tool.HttpGetTask;
import com.example.cong.helloworld.vo.Student;
import com.example.cong.helloworld.vo.StudentClass;
import com.google.gson.Gson;

import layout.StudentsFragment;

/**
 * Created by cong on 2017-06-08.
 */

public class StudentsController implements HttpCallBackService{

    private StudentsFragment fragment;

    public StudentsController(StudentsFragment fragment) {
        this.fragment = fragment;
    }

    public void getStudents(String id){
        System.out.println("listening...");
        Context context= SampleApplication.getContext();
        String url=context.getString(R.string.base_url)+context.getString(R.string.student_list_path)+"/"+id+context.getString(R.string.students_path);

        HttpGetTask getTask=new HttpGetTask(this);
        getTask.execute(url);
    }



    @Override
    public void callback(String json) {
        System.out.println("get students json:"+json);
        Gson gson=new Gson();
        Student[] students=gson.fromJson(json,Student[].class);
        fragment.showStudents(students);
    }
}
