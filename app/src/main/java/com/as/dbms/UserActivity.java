package com.as.dbms;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        setTitle("Customer List");
        ListView listView=findViewById(R.id.listView);
        final ArrayList<String> users = new ArrayList<>();
        try {
            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Customer", MODE_PRIVATE, null);
            Cursor c = myDatabase.rawQuery("SELECT * FROM customer", null);

            int name = c.getColumnIndex("name");
            c.moveToFirst();
            while (c != null) {
                users.add(c.getString(name));
                c.moveToNext();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,users);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent=new Intent(getApplicationContext(),UserDetails.class);
                intent.putExtra("name",users.get(position));
                startActivity(intent);
            }
        });
    }
}
