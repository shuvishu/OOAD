package com.example.sairam.ooad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class worker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker);
    }
    public void addmother(View view)
    {
        startActivity(new Intent(worker.this,addnewmother.class));
    }
    public void updatemotherinfo(View view)
    {

    }
}
