package com.example.divakar.vigilvisor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Techer_score_report extends AppCompatActivity {
    String json_string;
    JSONObject jsonObject = null;
    JSONArray jsonArray = null;
    ContactAdapterScore contactAdapter;
    ListView listView;
    int count = 0;
    ArrayList<String> itemlist = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_techer_score_report);
        listView = (ListView) findViewById(R.id.listview1);
        contactAdapter = new ContactAdapterScore(this, R.layout.row_score);
        listView.setAdapter(contactAdapter);
        json_string = getIntent().getExtras().getString("json_data2");
        Log.e("err", json_string);
        try {
            //Log.e("err", json_string);
            jsonObject = new JSONObject(json_string);
            System.out.println(jsonObject);


            jsonArray = jsonObject.getJSONArray("server_response");
            String PRN;
            String Score = new String();
            while (count < jsonArray.length()) {
                JSONObject JO = jsonArray.getJSONObject(count);
                PRN = JO.getString("PRN");
                Score = JO.getString("Score");
                ContactScore contacts = new ContactScore(PRN,Score);
                contactAdapter.add(contacts);
                count++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
