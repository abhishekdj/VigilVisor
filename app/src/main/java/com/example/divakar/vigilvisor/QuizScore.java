package com.example.divakar.vigilvisor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class QuizScore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_score);
        String Score=new String();
        Score=getIntent().getExtras().getString("Score");
        TextView t;
        t=(TextView)findViewById(R.id.textView12);
        t.setText(Score);
    }
}
