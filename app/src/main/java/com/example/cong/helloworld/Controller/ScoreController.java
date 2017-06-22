package com.example.cong.helloworld.Controller;

import android.content.Context;

import com.example.cong.helloworld.Activity.SampleApplication;
import com.example.cong.helloworld.R;
import com.example.cong.helloworld.Tool.HttpGetTask;
import com.example.cong.helloworld.vo.AllScore;
import com.example.cong.helloworld.vo.ScoreWrapper;
import com.google.gson.Gson;

import layout.ScoreStatistic;

/**
 * Created by cong on 2017-06-19.
 */

public class ScoreController implements HttpCallBackService{
    private ScoreStatistic fragement;

    public ScoreController(ScoreStatistic scoreStatistic) {
        this.fragement=scoreStatistic;
    }

    public void getScores(int assignment){
        Context context= SampleApplication.getContext();
        String url=context.getString(R.string.base_url)+context.getString(R.string.assignment)+"/"+assignment+context.getString(R.string.score);
        HttpGetTask getTask=new HttpGetTask(this);
        getTask.execute(url);
    }


    @Override
    public void callback(String json) {
        System.out.println("get score json:"+json);
        Gson gson=new Gson();
        ScoreWrapper scores=gson.fromJson(json,ScoreWrapper.class);
        fragement.setData(scores.getQuestions());
    }
}
