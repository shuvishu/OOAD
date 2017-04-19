package com.example.sairam.ooad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {

    EditText F_NAME,L_NAME,Role;
    String f_name,l_name,role;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        F_NAME=(EditText)findViewById(R.id.rmnid);
        L_NAME=(EditText)findViewById(R.id.rmname);
        Role= (EditText) findViewById(R.id.role);
    }
    public void reg_server(View view){
        f_name=F_NAME.getText().toString();
        l_name=L_NAME.getText().toString();
        role=Role.getText().toString();
        //role=ROLE.getText().toString();
        String method="Register";
        Toast.makeText(this,f_name+" "+l_name+" "+role,Toast.LENGTH_LONG).show();
        BackGroundTask backGroundTask=new BackGroundTask(this);
        backGroundTask.execute(method,f_name,l_name,role);
        finish();
    }
}
