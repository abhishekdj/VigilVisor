package com.example.divakar.vigilvisor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class createpoll extends AppCompatActivity {


    String Question;
    EditText editTextQuestion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createpoll);
        editTextQuestion=(EditText)findViewById(R.id.editText9);
    }

    public void Submit(View view) {


        Question=editTextQuestion.getText().toString();
        String method="GO";
        Poll_database_connectivity poll_database_connectivity=new Poll_database_connectivity(this);
        poll_database_connectivity.execute(method,Question);

        finish();

    }

}
