package com.example.cong.helloworld.Controller;

import android.content.Context;

import com.example.cong.helloworld.Activity.SampleApplication;
import com.example.cong.helloworld.R;
import com.example.cong.helloworld.Tool.HttpGetTask;
import com.example.cong.helloworld.vo.Practice;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import layout.PracticeFragment;

/**
 * Created by cong on 2017-06-12.
 */

public class PracticeController implements HttpCallBackService{


    private PracticeFragment practiceFragment;

    private int count=0;

    private List<Practice> allPractice=new ArrayList<>();

    public PracticeController(PracticeFragment practiceFragment) {
        this.practiceFragment = practiceFragment;
    }

    public void getPractice(){
        Context context= SampleApplication.getContext();

        String[] paths={
          context.getString(R.string.exam_path),context.getString(R.string.homework_path),context.getString(R.string.exercise_path)
        };

        for(String path:paths){
            HttpGetTask getTask=new HttpGetTask(this);
            String url=context.getString(R.string.base_url)+context.getString(R.string.course_path)+"/"+context.getString(R.string.default_courseId)+path;
            getTask.execute(url);
        }

    }

    @Override
    public void callback(String json) {
        System.out.println("get practice json:"+json);
        Gson gson=new Gson();
        Practice[] practices=gson.fromJson(json,Practice[].class);
        for(Practice practice:practices){
            allPractice.add(practice);
        }
        count++;
        if(count>=3){
            practiceFragment.showPractice(allPractice);
        }
    }
}
