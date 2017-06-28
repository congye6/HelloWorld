package com.example.cong.helloworld.Activity;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.example.cong.helloworld.Activity.listener.StudentTabListener;
import com.example.cong.helloworld.Activity.listener.TabListener;
import com.example.cong.helloworld.Activity.listener.TeacherTabListener;
import com.example.cong.helloworld.Controller.LoginController;
import com.example.cong.helloworld.R;
import com.example.cong.helloworld.Tool.PropertyTool;

import layout.LoginFragment;

public class MainActivity  extends AppCompatActivity {

    private TabListener listener;

    private LoginFragment loginFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setDefaultFragment();

    }



    /**
     * 设置默认的
     */
    private void setDefaultFragment() {


        Context context=SampleApplication.getContext();
        LoginController loginController=new LoginController();

        String password=PropertyTool.getInfo(context,context.getString(R.string.password));
        String username=PropertyTool.getInfo(context,context.getString(R.string.username));
        if(!TextUtils.isEmpty(password)&&!TextUtils.isEmpty(username)){
            loginController.login(username,password);
        }


        showTab( context);


    }

    public void showTab(Context context) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        String isLogin= PropertyTool.getInfo(context,context.getString(R.string.isLogin));
        if(isLogin!=null&&isLogin.equals("true")){
            String type=PropertyTool.getInfo(context,"type");
            if(type.equals(context.getString(R.string.type_teacher))){
                listener=new TeacherTabListener(this);

                listener.setDefaultFragment();
            }else{
                listener=new StudentTabListener(this);
                listener.setDefaultFragment();
            }

        }else{
            loginFragment= LoginFragment.newInstance();
            transaction.replace(R.id.fragment_container, loginFragment);

            transaction.commit();

        }
    }


    public void login(View view){
        LoginController controller=new LoginController(loginFragment);
        EditText username=(EditText)findViewById(R.id.username);
        EditText password=(EditText)findViewById(R.id.password);
        controller.login(username.getText().toString(),password.getText().toString());
    }

    public void showStudents(Fragment studentsFragment){
        changeFragment(studentsFragment);
    }

    public void showLogin(){
        loginFragment=LoginFragment.newInstance();
        changeFragment(loginFragment);
    }

    public void changeFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }


}
