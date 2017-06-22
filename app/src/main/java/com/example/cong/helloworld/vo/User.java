package com.example.cong.helloworld.vo;

import android.content.Context;

import com.example.cong.helloworld.Activity.SampleApplication;
import com.example.cong.helloworld.R;
import com.example.cong.helloworld.Tool.PropertyTool;

/**
 * Created by cong on 2017-05-31.
 * {
 "username":"...",
 "name":"..."
 "type":"student"|"teacher"|"admin",
 "avatar":"image url",
 "gender":"male"|"female",
 "email":"xxx@xxx.com",

 //student attribute
 "gitId":int,
 "number":"141250123",


 //teacher arrribute
 "authority":"true"|"false",

 }
 */

public class User {

    public String username;

    public String name;

    public String type;

    public String avatar;

    public String gender;

    public String email;

    //student attribute
    public int gitId;
    public String number;

    //tercher attribute
    public String authority;


    public void save(){
        Context context= SampleApplication.getContext();
        String[] keys={
                context.getString(R.string.username),"name","type","avatar","gender","email","gitId","number","authority"
        };
        String[] values={
                username,name,type,avatar,gender,email,gitId+"",number,authority
        };
        PropertyTool.saveInfos(context,keys,values);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGitId() {
        return gitId;
    }

    public void setGitId(int gitId) {
        this.gitId = gitId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
