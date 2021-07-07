package com.example.divakar.vigilvisor;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")
public class Student_quiz_attempt extends AppCompatActivity {
    String json_string;
    JSONObject jsonObject = null;
    JSONArray jsonArray = null;
    ContactAdapter contactAdapter;
    ListView listView;
    TextView textViewTime;
    int count = 0;
    Button BtnDone;
    String [] Answer= new String[100];
    int Score=0;
    RadioButton rb;
    RadioGroup rg;
    View view;
    ArrayList<String> itemlist = new ArrayList<String>();
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_quiz_attempt);
//        Timer timer = new Timer();

//        timer.schedule(new TimerTask() {

  //          public void run() {

                //here you can start your Activity B.
    //            Intent intent = new Intent(Student_quiz_attempt.this,QuizScore.class);
                //intent.putExtra("Score",String.valueOf(Score));
      //          startActivity(intent);

        //    }

        //}, 300000);
        textViewTime=(TextView)findViewById(R.id.textView8);
        textViewTime.setText("00:03:00");
        new CountDownTimer(300000, 1000) {

            public void onTick(long millisUntilFinished) {
                long millis=millisUntilFinished;
                String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
                        TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                        TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
               // System.out.println(hms);

                textViewTime.setText("Time remaining: " +hms);
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                textViewTime.setText("done!");
            }

        }.start();
        //btnStart=(Button)findViewById(R.id.button10);
        listView = (ListView) findViewById(R.id.listview);
       // final Student_menu.CounterClass timer = new Student_menu.CounterClass(180000, 1000);
        listView.setNestedScrollingEnabled(false);


        contactAdapter = new ContactAdapter(this, R.layout.row_layout);
        listView.setAdapter(contactAdapter);
        json_string = getIntent().getExtras().getString("json_data");
      //  Toast.makeText(Student_quiz_attempt.this, json_string, Toast.LENGTH_SHORT).show();
        try {
            //Log.e("err", json_string);
            jsonObject = new JSONObject(json_string);
            System.out.println(jsonObject);


            jsonArray = jsonObject.getJSONArray("server_response");

            String Question;
            String OptionA = new String();
            String OptionB = new String();
            String OptionC = new String();
            String OptionD = new String();
            String Ans = null;
            while (count < jsonArray.length()) {
                JSONObject JO = jsonArray.getJSONObject(count);
                Question = JO.getString("Question");
                OptionA = JO.getString("OptionA");
                OptionB = JO.getString("OptionB");
                OptionC = JO.getString("OptionC");
                OptionD = JO.getString("OptionD");
                Ans=JO.getString("Answer");
               // Answer[count]=Ans;
                Contacts contacts = new Contacts(Question, OptionA, OptionB, OptionC, OptionD);
                contactAdapter.add(contacts);
                Answer[count]=Ans;
                count++;
                Log.e("answer", Ans);
            }



        } catch (JSONException e) {
            e.printStackTrace();
        }

        final ListView list = (ListView) findViewById(R.id.listview);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object listItem = listView.getItemAtPosition(position);
                //Log.e("count", String.valueOf(position));
                System.out.println(listItem);
            }
        });


        BtnDone = (Button) findViewById(R.id.submit_button);
        BtnDone.setOnClickListener( new View.OnClickListener() {
            public View getViewByPosition(int pos, ListView listView) {
                final int firstListItemPosition = listView.getFirstVisiblePosition();
                final int lastListItemPosition = firstListItemPosition + listView.getChildCount() - 1;

                if (pos < firstListItemPosition || pos > lastListItemPosition ) {
                    return listView.getAdapter().getView(pos, null, listView);
                } else {
                    final int childIndex = pos - firstListItemPosition;
                    return listView.getChildAt(childIndex);
                }
            }

            @Override
            public void onClick(View v) {
                //get Values ?????
//                RadioGroup rg;
  //              RadioButton rb;
                View view;
                String abs = null;

                int i=0,idx;
                while(i<count)
                {
                    listView.setNestedScrollingEnabled(false);
                    view=getViewByPosition(i,listView);

                    rg= (RadioGroup)view.findViewById(R.id.radioGroupAnswers);

                    int radioButtonID = rg.getCheckedRadioButtonId();

                    rb=(RadioButton)view.findViewById(radioButtonID);
                    idx=rg.indexOfChild(rb);
                    if(idx==0)
                        abs="A";
                    if(idx==1)
                        abs="B";
                    if(idx==2)
                        abs="C";
                    if(idx==3)
                        abs="D";


                    if(Answer[i].equals(abs))
                        Score++;
                   // Toast.makeText(Student_quiz_attempt.this,String.valueOf(Score), Toast.LENGTH_SHORT).show();
                    Log.e("idx  ", ""+idx);
                    Log.e("id  ", ""+Answer[i]);

                    Log.e("Your Score is  ", ""+Score);
                    i++;
                }
                Toast.makeText(Student_quiz_attempt.this,"YourScore is  "+String.valueOf(Score), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Student_quiz_attempt.this,QuizScore.class);
                intent.putExtra("Score",String.valueOf(Score));
                startActivity(intent);
            }
        });

        Timer timer1 = new Timer();

        timer1.schedule(new TimerTask() {



            public void run() {

                BtnDone.post(new Runnable(){
                    @Override
                    public void run() {
                        BtnDone.performClick();
                    }
                });

                //BtnDone.performClick();
                //here you can start your Activity B.
                //Intent intent = new Intent(Student_quiz_attempt.this,QuizScore.class);
                //intent.putExtra("Score",String.valueOf(Score));
                //startActivity(intent);

            }

        }, 300000);

    }


}