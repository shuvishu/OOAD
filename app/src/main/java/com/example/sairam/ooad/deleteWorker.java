package com.example.sairam.ooad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class deleteWorker extends AppCompatActivity {

    EditText WDELETE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_worker);
        WDELETE= (EditText) findViewById(R.id.ETdeleteworker);
    }
    public void delete_worker(View view)
    {
        String delUserName=WDELETE.getText().toString();
        String method ="deleteworker";
        BackGroundTask backGroundTask=new BackGroundTask(this);
        backGroundTask.execute(method,delUserName);
    }
}
