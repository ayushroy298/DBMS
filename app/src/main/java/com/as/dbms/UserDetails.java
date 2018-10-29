package com.as.dbms;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class UserDetails extends AppCompatActivity {

    TextView name;
    TextView id;
    TextView phone;
    TextView duration;
    TextView roomtype;
    TextView price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        Intent intent=getIntent();
        name=findViewById(R.id.name);
        id=findViewById(R.id.id);
        phone=findViewById(R.id.phone);
        duration=findViewById(R.id.duration);
        roomtype=findViewById(R.id.roomtypeTV);
        price=findViewById(R.id.priceTV);
        String intentName=intent.getStringExtra("name");
        setTitle(intentName);
        try {
            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Customer", MODE_PRIVATE, null);
            Cursor c = myDatabase.rawQuery("SELECT * FROM customer WHERE name = '"+intentName+"'", null);

            int name1 = c.getColumnIndex("name");
            int id1=c.getColumnIndex("id");
            int phone1=c.getColumnIndex("pno");
            int duration1=c.getColumnIndex("duration");
            int roomtype1=c.getColumnIndex("roomtype");
            int price1=c.getColumnIndex("price");
            c.moveToFirst();
            while (c != null)
            {
                name.setText("Name : "+c.getString(name1));
                id.setText("User ID : "+c.getString(id1));
                phone.setText("Phone Number : "+c.getString(phone1));
                duration.setText("Duration : "+c.getString(duration1));
                roomtype.setText("Room Type : "+c.getString(roomtype1));
                price.setText("Price : "+c.getString(price1));
                c.moveToNext();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}
