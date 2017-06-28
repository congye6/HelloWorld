package com.example.cong.helloworld.Activity.listener;

import android.view.View;

import com.example.cong.helloworld.Activity.MainActivity;
import com.example.cong.helloworld.vo.Practice;

import layout.ScoreStatistic;

/**
 * Created by cong on 2017-06-28.
 */

public class TeacherScoreListener implements View.OnClickListener{

    private MainActivity mainActivity;

    private int assignmentId;

    public TeacherScoreListener(MainActivity mainActivity, int assignmentId) {
        this.mainActivity = mainActivity;
        this.assignmentId = assignmentId;
    }

    @Override
    public void onClick(View v) {
        ScoreStatistic fragment=ScoreStatistic.newInstance(assignmentId);
        mainActivity.changeFragment(fragment);
    }
}
