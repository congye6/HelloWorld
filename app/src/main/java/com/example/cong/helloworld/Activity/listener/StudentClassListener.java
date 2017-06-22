package com.example.cong.helloworld.Activity.listener;

import android.view.View;

import com.example.cong.helloworld.Activity.MainActivity;
import com.example.cong.helloworld.Controller.StudentListController;
import com.example.cong.helloworld.Controller.StudentsController;

import layout.StudentsFragment;

/**
 * Created by cong on 2017-06-08.
 */

public class StudentClassListener implements View.OnClickListener{


    private String classId;

    private MainActivity activity;


    public StudentClassListener(String classId, MainActivity activity) {
        this.classId = classId;
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        StudentsFragment fragment=StudentsFragment.newInstance(classId);
        activity.showStudents(fragment);
    }
}
