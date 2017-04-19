package com.example.sairam.ooad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class addWorker extends AppCompatActivity {


    EditText NWUSERNAME,NWPASS,NWNAME,NWCONTACT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_worker);
        NWUSERNAME= (EditText) findViewById(R.id.NWusername);
        NWPASS= (EditText) findViewById(R.id.NWpass);
        NWNAME= (EditText) findViewById(R.id.NWname);
        NWCONTACT= (EditText) findViewById(R.id.NWcontact);
    }
    public void addNewWorker(View view){
        String nwusername=NWUSERNAME.getText().toString();
        String nwpass=NWPASS.getText().toString();
        String nwname=NWNAME.getText().toString();
        String nwcontact=NWCONTACT.getText().toString();
        String method="addnewworker";
        BackGroundTask backGroundTask=new BackGroundTask(this);
        backGroundTask.execute(method,nwusername,nwpass,nwname,nwcontact);
    }
}
