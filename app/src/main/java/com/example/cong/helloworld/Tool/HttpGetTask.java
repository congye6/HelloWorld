package com.example.cong.helloworld.Tool;

import android.content.Context;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;

import com.example.cong.helloworld.Activity.SampleApplication;
import com.example.cong.helloworld.Controller.HttpCallBackService;
import com.example.cong.helloworld.R;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by cong on 2017-05-15.
 */

public class HttpGetTask extends AsyncTask<String,Integer,String> {


    private HttpCallBackService callBackService;

    public HttpGetTask(HttpCallBackService callBackService) {
        this.callBackService = callBackService;
    }

    public String get(String url){
        //将URL与参数拼接
        HttpGet getMethod = new HttpGet(url);
        HttpClient httpClient = new DefaultHttpClient();
        try {
            Context context= SampleApplication.getContext();
            String username=PropertyTool.getInfo(context,context.getString(R.string.username));
            String password=PropertyTool.getInfo(context,context.getString(R.string.password));
//            + (Base64.encodeToString((username+":"+password).getBytes(),Base64.DEFAULT))
            getMethod.addHeader("Authorization","Basic bGl1cWluOjEyMw==" );

            HttpResponse response = httpClient.execute(getMethod); //发起GET请求
            BufferedReader bufferedReader2 = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            StringBuilder builder=new StringBuilder();
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
