package com.example.cong.helloworld.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.example.cong.helloworld.R;

/**
 * Created by cong on 2017-05-09.
 */


public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Intent intent=this.getIntent();
        String name=intent.getStringExtra("name");
        BootstrapButton button=(BootstrapButton)findViewById(R.id.login);
        button.setText(name);
    }

    public void click(View view){
        EditText name=(EditText)findViewById(R.id.username);
        Bundle bundle=new Bundle();
        bundle.putString("name",name.getText().toString());
        Intent intent=new Intent(this,MainActivity.class);
        intent.putExtras(bundle);
        this.startActivity(intent);
    }

}
