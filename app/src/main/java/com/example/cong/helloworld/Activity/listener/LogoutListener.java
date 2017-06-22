package com.example.cong.helloworld.Activity.listener;

import android.view.View;

import com.example.cong.helloworld.Activity.MainActivity;
import com.example.cong.helloworld.Activity.SampleApplication;
import com.example.cong.helloworld.Tool.PropertyTool;

import layout.LoginFragment;

/**
 * Created by cong on 2017-06-17.
 */

public class LogoutListener implements View.OnClickListener{


    private MainActivity activity;

    public LogoutListener(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        PropertyTool.clear(SampleApplication.getContext());
        activity.showLogin();
    }
}
