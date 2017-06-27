package com.example.cong.helloworld.Tool;

import android.content.Context;
import android.content.Entity;
import android.os.AsyncTask;
import android.util.Base64;

import com.example.cong.helloworld.Activity.SampleApplication;
import com.example.cong.helloworld.Controller.HttpCallBackService;
import com.example.cong.helloworld.R;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cong on 2017-05-15.
 */

public class HttpPostTask extends AsyncTask<String,Integer,String> {
    private JSONObject jsonObject;

    private HttpCallBackService callBackService;

    private boolean isNeedAuth=true;

    public HttpPostTask(JSONObject jsonObject, HttpCallBackService callBackService){
        this.jsonObject=jsonObject;
        this.callBackService=callBackService;
    }

    public void setAuth(boolean isNeedAuth){
        this.isNeedAuth=isNeedAuth;
    }

    public String get(String url){
        //将你的url放到post中
        HttpPost postMethod = new HttpPost(url);
        HttpClient httpClient = new DefaultHttpClient();
        try {
            if(jsonObject!=null){
                //设置http请求的body，这里我传入了json数据
                StringEntity entity=new StringEntity(jsonObject.toString(),"utf-8");
                entity.setContentType("application/json");
                postMethod.setEntity(entity);
            }
            //执行post请求，获得response
            HttpResponse response = httpClient.execute(postMethod);

            StringBuilder builder = new StringBuilder();
            //从response中获取body里面的内容
            BufferedReader bufferedReader2 = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));
            //逐行读取内容
            for (String s = bufferedReader2.readLine(); s != null; s = bufferedReader2
                    .readLine()) {
                builder.append(s);

            }

            return builder.toString();
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected String doInBackground(String... params) {
        return get(params[0]);
    }

    /**
     * 这里的String参数对应AsyncTask中的第三个参数（也就是接收doInBackground的返回值）
     * 在doInBackground方法执行结束之后在运行，并且运行在UI线程当中 可以对UI空间进行设置
     */
    @Override
    protected void onPostExecute(String result) {
        callBackService.callback(result);
    }
}
