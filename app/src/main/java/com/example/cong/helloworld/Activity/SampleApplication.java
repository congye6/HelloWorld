package com.example.cong.helloworld.Activity;

import android.app.Application;
import android.content.Context;

import com.beardedhen.androidbootstrap.TypefaceProvider;

/**
 * Created by cong on 2017-05-09.
 */

public class SampleApplication extends Application{

    private static Application instance;

    public static Application getAplication(){
        return instance;
    }

    public static Context getContext(){
        return instance.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        TypefaceProvider.registerDefaultIconSets();
    }
}
