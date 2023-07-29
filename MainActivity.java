package com.example.onlineexamination;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.editTextText);
        e2=(EditText)findViewById(R.id.editTextText2);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,Second.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                if (s1.equals("")||s2.equals(""))
                {
                    Toast.makeText(MainActivity.this, "plz fill all", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    SQLiteDatabase data=openOrCreateDatabase("netcamp",MODE_PRIVATE,null);
                    data.execSQL("create table if not exists student(name varchar,email varchar,phone varchar)");
                    String s3="select * from student where name='"+s1+ "' and email='" +s2+"' ";
                    Cursor c1=data.rawQuery(s3,null);
                    if(c1.getCount()>0)
                    {
                        Toast.makeText(MainActivity.this, "login done", Toast.LENGTH_SHORT).show();
                        Intent j=new Intent(MainActivity.this,Four.class);
                        startActivity(j);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "not done", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
