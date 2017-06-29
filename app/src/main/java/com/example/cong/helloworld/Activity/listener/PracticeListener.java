package com.example.cong.helloworld.Activity.listener;

import android.view.View;

import com.example.cong.helloworld.Activity.MainActivity;
import com.example.cong.helloworld.vo.Practice;

import layout.PracticeDetailFragment;
import layout.PracticeFragment;

/**
 * Created by cong on 2017-06-13.
 */

public class PracticeListener implements View.OnClickListener{

    private Practice practice;

    private MainActivity mainActivity;

    public PracticeListener(Practice practice,MainActivity mainActivity) {
        this.practice = practice;
        this.mainActivity=mainActivity;
    }

    @Override
    public void onClick(View v) {
        PracticeDetailFragment fragment=PracticeDetailFragment.newInstance(practice);
        mainActivity.changeFragment(fragment);
    }
}
