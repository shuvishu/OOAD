package com.example.sairam.ooad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class updateWorker extends AppCompatActivity {
    EditText ETUNAMEWORKER,ETCONTACT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_worker);
        ETUNAMEWORKER= (EditText) findViewById(R.id.Wusername);
        ETCONTACT= (EditText) findViewById(R.id.UpdatedContact);
    }
    public void UpdatedContact(View view)
    {
        String UWusername=ETUNAMEWORKER.getText().toString();
        String contact=ETCONTACT.getText().toString();
        String method ="updateworker";
        BackGroundTask backGroundTask=new BackGroundTask(this);
        backGroundTask.execute(method,UWusername,contact);
    }
}
