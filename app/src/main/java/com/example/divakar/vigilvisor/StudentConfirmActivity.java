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

public class StudentConfirmActivity extends AppCompatActivity {

    private EditText editTextPRN;
    private EditText editTextPhone;
    private EditText editTextConfirmOtp;

    private Button buttonConfirm;
    private RequestQueue requestQueue;

    private String PRN;

    private String Phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_confirm);
    }

    public void Login(final View view)  {
        Intent intent = new Intent("com.example.divakar.vigilvisor.Student_menu");
        startActivity(intent);
    }


}
