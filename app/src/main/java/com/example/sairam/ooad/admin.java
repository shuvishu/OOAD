package com.example.sairam.ooad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class admin extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

    }
    public void add_worker(View view)
    {
        startActivity(new Intent(admin.this,addWorker.class));
    }
    public void update_worker(View view)
    {
        startActivity(new Intent(admin.this,updateWorker.class));
    }
    public void delete_worker(View view)
    {
        startActivity(new Intent(admin.this,deleteWorker.class));
    }
}
