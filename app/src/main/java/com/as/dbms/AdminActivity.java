package com.as.dbms;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdminActivity extends AppCompatActivity
{
    EditText name;
    EditText id;
    EditText phone;
    EditText duration;
    EditText roomtype;
    EditText price;
    SQLiteDatabase myDatabase;
    public void add(View view)
    {
        name=findViewById(R.id.name);
        id=findViewById(R.id.id);
        phone=findViewById(R.id.phone);
        duration=findViewById(R.id.duration);
        roomtype=findViewById(R.id.roomType);
        price=findViewById(R.id.priceTV);

        try {
            String sql = "INSERT INTO customer (name,id,pno,duration,roomtype,price) VALUES (?,?,?,?,?,?)";
            SQLiteStatement statement = myDatabase.compileStatement(sql);

            statement.bindString(1, name.getText().toString());
            statement.bindString(2, id.getText().toString());
            statement.bindString(3, phone.getText().toString());
            statement.bindString(4, duration.getText().toString());
            statement.bindString(5, roomtype.getText().toString());
            statement.bindString(6, price.getText().toString());
            statement.execute();
            Toast.makeText(this, name.getText().toString()+"'s data added successfully!!!", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(getApplicationContext(),UserActivity.class);
            startActivity(intent);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        setTitle("New Customer");
        try {
            myDatabase = this.openOrCreateDatabase("Customer", MODE_PRIVATE, null);
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS customer (name VARCHAR(20) PRIMARY KEY, id INT, pno INT, duration INT, roomtype VARCHAR(20), price INT)");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
