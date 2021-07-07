package com.example.divakar.vigilvisor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class student_poll extends AppCompatActivity {
    String json_string;
    String Option1;
    String Option2;
    JSONObject jsonObject=null;
    JSONArray jsonArray=null;
    ContactAdapterPoll contactAdapterPoll;
    ListView listView;
    Button BtnDone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_poll);
        listView =(ListView)findViewById(R.id.listview);

        contactAdapterPoll=new ContactAdapterPoll(this,R.layout.row_layout);
        listView.setAdapter(contactAdapterPoll);
        json_string=getIntent().getExtras().getString("json_data");

        try {
            jsonObject=new JSONObject(json_string) ;
            System.out.println(jsonObject);


            jsonArray=jsonObject.getJSONArray("server_response");
            int count=0;
            String Question;


            while (count<jsonArray.length())
            {
                JSONObject JO=jsonArray.getJSONObject(count);
                Question=JO.getString("Question");


                ContactsPoll contactsPolloll=new ContactsPoll(Question);
                contactAdapterPoll.add(contactsPolloll);

                count++;

            }
            Log.e("count", String.valueOf(count));


        } catch (JSONException e) {
            e.printStackTrace();
        }
     /*   public void Submit(View view) {


            Option1=editTextOption1.getText().toString();
            Option4=editTextOption4.getText().toString();
            Answer=editTextAnswer.getText().toString();
            String method="GO";
            Quiz_database_connectivity quiz_database_connectivity=new Quiz_database_connectivity(this);
            quiz_database_connectivity.execute(method,Question,Option1,Option2,Option3,Option4,Answer);

            finish();

        }*/



    }

}





