package com.example.cong.helloworld.Controller;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.http.AndroidHttpClient;
import android.view.View;
import android.widget.EditText;

import com.example.cong.helloworld.Activity.MainActivity;
import com.example.cong.helloworld.Activity.RegisterActivity;
import com.example.cong.helloworld.Activity.SampleApplication;
import com.example.cong.helloworld.R;
import com.example.cong.helloworld.Tool.HttpGetTask;
import com.example.cong.helloworld.Tool.HttpPostTask;
import com.example.cong.helloworld.Tool.PropertyTool;
import com.example.cong.helloworld.vo.User;
import com.google.gson.Gson;


import org.apache.http.HttpEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import layout.LoginFragment;

/**
 * Created by cong on 2017-05-15.
 */

public class LoginController implements HttpCallBackService{
    //"http://115.29.184.56:8088/gitlab/login"
    private  String password;

    private LoginFragment fragment;

    public LoginController(LoginFragment fragment){
        this.fragment=fragment;
    }

    public LoginController(){

    }

    public void login(String username,String password)  {
        List<BasicNameValuePair> params=new ArrayList<>();
        Application application= SampleApplication.getAplication();

        String url=application.getString(R.string.base_url)+application.getString(R.string.login_path);;

        JSONObject info=new JSONObject();
        try {

            info.put(application.getString(R.string.username),username);
            info.put(application.getString(R.string.password),password);
            this.password=password;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        HttpPostTask task=new HttpPostTask(info,this);
        task.setAuth(false);
        task.execute(url);
    }


    @Override
    public void callback(String json) {
        System.out.println(json);
        Context context=SampleApplication.getContext();
        if(json==""){
            PropertyTool.saveInfo(context,context.getString(R.string.isLogin),"false");
            PropertyTool.saveInfo(context,context.getString(R.string.username),"");
            PropertyTool.saveInfo(context,context.getString(R.string.password),"");
            if(fragment!=null)
            fragment.showError();
            return;
        }
        Gson gson=new Gson();
        User user=gson.fromJson(json, User.class);

        user.save();
        PropertyTool.saveInfo(context,context.getString(R.string.password),password);
        PropertyTool.saveInfo(context,context.getString(R.string.isLogin),"true");
        if(fragment!=null){
            fragment.showSuccess();
            MainActivity activity=(MainActivity)fragment.getActivity();
            activity.showTab(SampleApplication.getContext());
        }

    }
}
