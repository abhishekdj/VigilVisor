package com.example.divakar.vigilvisor;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static android.R.id.edit;


public class LoginActivitystudent extends AppCompatActivity {

     EditText editTextPRN;
     EditText editTextPhone;
     EditText editTextConfirmOtp;

     Button buttonnext;
     RequestQueue requestQueue;

     String PRN;

     String Phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //EditText ET_PRN_NO,ET_PHONE;
        //String prn_no,phone;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activitystudent);
        editTextPRN=(EditText)findViewById(R.id.editText);
        editTextPhone=(EditText)findViewById(R.id.editText4);
    }
    public void GO(View view) {
        Intent intent = new Intent("com.example.divakar.vigilvisor.StudentConfirmActivity");

        PRN=editTextPRN.getText().toString();
        Phone=editTextPhone.getText().toString();
        String method="GO";
        BackgroundTask backgroundTask=new BackgroundTask(this);
        backgroundTask.execute(method,PRN,Phone);
        startActivity(intent);
        finish();

    }
}
