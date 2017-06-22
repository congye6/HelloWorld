package com.example.cong.helloworld.Activity;

import android.app.LauncherActivity;
import android.os.Bundle;

/**
 * Created by cong on 2017-05-09.
 */

public class MenuActivity extends LauncherActivity{

    String[] names={"设置","帮助"};
    Class<?>[] clazzs={MainActivity.class,TestActivity.class};

    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
//        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,,names);
    }
}
