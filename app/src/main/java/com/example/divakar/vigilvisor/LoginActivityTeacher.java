package com.example.divakar.vigilvisor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivityTeacher extends AppCompatActivity {
    EditText username;
    EditText Pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_teacher);
        username=(EditText)findViewById(R.id.editText2);
        Pass=(EditText)findViewById(R.id.editText3);
    }
    public void ht(View view)
    {
        String a="RathodAS";
        String b="12345";
        String a1="Jarvis";
        String b1="0000";
        String a2="Hydra";
        String b2="1111";
        String struser = username.getText().toString();
        String strpass = Pass.getText().toString();
        if(struser.equals(a)&&strpass.equals(b)) {
            Toast.makeText(this,"Welcome "+struser,Toast.LENGTH_LONG).show();

            Intent intent = new Intent("com.example.divakar.vigilvisor.Teacher_menu");
            startActivity(intent);
        }

        else if(struser.equals(a1)&&strpass.equals(b1)) {
            Toast.makeText(this,"Welcome "+struser,Toast.LENGTH_LONG).show();

            Intent intent = new Intent("com.example.divakar.vigilvisor.Teacher_menu");
            startActivity(intent);
        }

        else if(struser.equals(a2)&&strpass.equals(b2)) {
            Toast.makeText(this,"Welcome "+struser,Toast.LENGTH_LONG).show();

            Intent intent = new Intent("com.example.divakar.vigilvisor.Teacher_menu");
            startActivity(intent);
        }
        else
            Toast.makeText(this,"Incorrect username or password",Toast.LENGTH_LONG).show();
    }
}
