package com.example.sairam.ooad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    EditText MID,MNAME;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        MID= (EditText) findViewById(R.id.mid);
        MNAME= (EditText) findViewById(R.id.mname);

    }
    public void do_login(View view){
        String mname=MNAME.getText().toString();
        String mid=MID.getText().toString();
        String method="login";
        BackGroundTask backGroundTask=new BackGroundTask(this);
        backGroundTask.execute(method,mname,mid);
    }

}
