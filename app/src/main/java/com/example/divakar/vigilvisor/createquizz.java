package com.example.divakar.vigilvisor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class createquizz extends AppCompatActivity {


    String Question;
    String Option1;
    String Option2;
    String Option3;
    String Option4;
    String Answer;
    EditText editTextQuestion;
    EditText editTextOption1;
    EditText editTextOption2;
    EditText editTextOption3;
    EditText editTextOption4;
    EditText editTextAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createquizz);
        editTextQuestion=(EditText)findViewById(R.id.editText7);
        editTextOption1=(EditText)findViewById(R.id.editText9);
        editTextOption2=(EditText)findViewById(R.id.editText10);
        editTextOption3=(EditText)findViewById(R.id.editText11);
        editTextOption4=(EditText)findViewById(R.id.editText12);
        editTextAnswer=(EditText)findViewById(R.id.editText8);
    }

    public void Submit(View view) {


        Question=editTextQuestion.getText().toString();
        Option1=editTextOption1.getText().toString();
        Option2=editTextOption2.getText().toString();
        Option3=editTextOption3.getText().toString();
        Option4=editTextOption4.getText().toString();
        Answer=editTextAnswer.getText().toString();
        String method="GO";
        Quiz_database_connectivity quiz_database_connectivity=new Quiz_database_connectivity(this);
        quiz_database_connectivity.execute(method,Question,Option1,Option2,Option3,Option4,Answer);

        finish();

    }
}
