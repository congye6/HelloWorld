package com.example.cong.helloworld.Activity.listener;

import android.view.View;

import com.example.cong.helloworld.Activity.MainActivity;

import layout.ScoreStatistic;
import layout.StudentScoreStatisticFragment;

/**
 * Created by cong on 2017-06-29.
 */

public class StudentScoreListener implements View.OnClickListener{
    private MainActivity mainActivity;

    private int assignmentId;

    private int studentId;

    public StudentScoreListener(MainActivity mainActivity, int assignmentId, int studentId) {
        this.mainActivity = mainActivity;
        this.assignmentId = assignmentId;
        this.studentId = studentId;
    }

    @Override
    public void onClick(View v) {
        StudentScoreStatisticFragment fragment=StudentScoreStatisticFragment.newInstance(assignmentId,studentId);
        mainActivity.changeFragment(fragment);
    }
}
