package com.example.divakar.vigilvisor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
     //private static Button button_sbm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
   /* public void onClickButtonListener(){
        button_sbm =(Button)findViewById(R.id.button);
        button_sbm.setOnClickListener();

    }*/
   /* public void rbclick(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.radioButton4: {
                if (checked) {
                    Intent intent = new Intent("com.example.divakar.vigilvisor.LoginActivitystudent");
                    startActivity(intent);
                }

            }
            case R.id.radioButton8: {
                if (checked) {
                    Intent intent = new Intent("com.example.divakar.vigilvisor.LoginActivityTeacher");
                    startActivity(intent);
                }

            }
            case R.id.radioButton9: {
                if (checked) {
                    Intent intent = new Intent("com.example.divakar.vigilvisor.LoginActivity_HOD");
                    startActivity(intent);
                }
            }
        }
    }*/
   public void rbclick1(View view)
   {
       Intent intent = new Intent("com.example.divakar.vigilvisor.LoginActivitystudent");
       startActivity(intent);
   }
    public void rbclick2(View view)
    {
        Intent intent = new Intent("com.example.divakar.vigilvisor.LoginActivityTeacher");
        startActivity(intent);
    }
    public void rbclick3(View view)
    {
        Intent intent = new Intent("com.example.divakar.vigilvisor.LoginActivity_HOD");
        startActivity(intent);
    }

}