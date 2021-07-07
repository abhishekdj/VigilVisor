package com.example.divakar.vigilvisor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Teacher_poll extends AppCompatActivity {
    String json_string;
    String json_string2;
   JSONObject jsonObject = null;
    JSONArray jsonArray = null;
    TextView textView;
    JSONObject jsonObject2 = null;
    JSONArray jsonArray2 = null;
    TextView textView2;
    //TextView textViewNo;
    //View view;
    int count=0;
    String YES;
    String No;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_poll);
       json_string = getIntent().getExtras().getString("json_data");
        json_string2 = getIntent().getExtras().getString("json_data2");
            Log.e("err2", json_string2);

        try {
            Log.e("err", json_string);
//            Log.e("err2", json_string2);
            jsonObject = new JSONObject(json_string);
            jsonObject2 = new JSONObject(json_string2);
        //    System.out.println(jsonObject);


           jsonArray = jsonObject.getJSONArray("server_response");

            jsonArray2 = jsonObject2.getJSONArray("server_response");

            //while (count < jsonArray.length()) {
                JSONObject JO = jsonArray.getJSONObject(0);
                YES = JO.getString("Count");
           JSONObject JO2 = jsonArray2.getJSONObject(0);
           // YES = JO.getString("Count");
           No=JO2.getString("Count");
            Log.e("count", YES);
            Log.e("countno", No);
            //}
           // textView = (TextView) findViewById(R.id.textView13);
//            textViewNo = (TextView) findViewById(R.id.textView16);

            textView= (TextView) findViewById(R.id.textView13);
            textView.setText(YES);
            textView2= (TextView) findViewById(R.id.textView16);
            textView2.setText(No);
        } catch (JSONException e) {
            e.printStackTrace();
        }
      //  textViewYes.setText(YES);
    }
}