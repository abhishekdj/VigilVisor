package com.example.divakar.vigilvisor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Teacher_menu extends AppCompatActivity {

    public void A(View view){}
    public void CP(View view){Intent intent = new Intent("com.example.divakar.vigilvisor.createpoll");
        startActivity(intent);}
    public void CQ(View view){Intent intent = new Intent("com.example.divakar.vigilvisor.createquizz");
        startActivity(intent);}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_menu);
       // init();
    }
}
