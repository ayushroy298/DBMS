package com.as.dbms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void adminClick(View view)
    {
        int a;
        Intent intent=new Intent(getApplicationContext(),AdminActivity.class);
        startActivity(intent);
    }

    public void userClick(View view)
    {
        Intent intent=new Intent(getApplicationContext(),UserActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
