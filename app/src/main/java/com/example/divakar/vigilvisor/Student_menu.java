package com.example.divakar.vigilvisor;


import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Student_menu extends AppCompatActivity {
    String JSON_STRING;
   static String json_string;
  //  public final ContactAdapter.CounterClass timer=new ContactAdapter.CounterClass(180000,1000);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_menu);

        }


        class Quiz extends AsyncTask<Void,Void,String>
        {
            String json_url;

            @Override
            protected void onPreExecute() {
                json_url="http://10.0.2.2/AndroidApp/student_quizz.php";

            }

            @Override
            protected String doInBackground(Void... params) {
                try {
                    URL url=new URL(json_url);
                    HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                    InputStream inputStream=httpURLConnection.getInputStream();
                    BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder stringBuilder=new StringBuilder();
                    while((JSON_STRING =bufferedReader.readLine())!=null)
                    {
                        stringBuilder.append(JSON_STRING+"\n");

                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return stringBuilder.toString().trim();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onProgressUpdate(Void... values) {
                super.onProgressUpdate(values);
            }

            @Override
            protected void onPostExecute(String result) {
//                Toast.makeText(Student_menu.this, result, Toast.LENGTH_SHORT).show();
                json_string=result;
                }
        }
    class Poll extends AsyncTask<Void,Void,String>
    {
        String json_url;

        @Override
        protected void onPreExecute() {
            json_url="http://10.0.2.2/AndroidApp/student_poll1.php";

        }

        @Override
        protected String doInBackground(Void... params) {
            try {
                URL url=new URL(json_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder=new StringBuilder();
                while((JSON_STRING =bufferedReader.readLine())!=null)
                {
                    stringBuilder.append(JSON_STRING+"\n");

                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            //Toast.makeText(Student_menu.this, result, Toast.LENGTH_SHORT).show();
            json_string=result;
        }
    }
    public void wq(View view)

    {
        new Quiz().execute();
        if(json_string==null)
        {
           // Toast.makeText(getApplicationContext(),"First get json",Toast.LENGTH_LONG).show();
        }
        else
        {

            Intent intent = new Intent(this,Student_quiz_attempt.class);


            intent.putExtra("json_data",json_string);

            startActivity(intent);


        }
    }
    public void cd(View view) {

        new Poll().execute();
        if(json_string==null)
        {
            //Toast.makeText(getApplicationContext(),"First get json",Toast.LENGTH_LONG).show();
        }
        else
        {

            Intent intent = new Intent(this,student_poll.class);


            intent.putExtra("json_data",json_string);
            //final ContactAdapter.CounterClass timer=new ContactAdapter.CounterClass(180000,1000);
           // timer.start();

            startActivity(intent);

        }

    }
/*    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("NewApi")
    public class CounterClass extends CountDownTimer {

        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
  /*      public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @TargetApi(Build.VERSION_CODES.GINGERBREAD)
        @SuppressLint("NewApi")
        @Override
        public void onTick(long millisUntilFinished) {
            long millis=millisUntilFinished;
            String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
            System.out.println(hms);
            ContactAdapter.ContactHolder.time.setText(hms);
        }

        @Override
        public void onFinish() {
            ContactAdapter.ContactHolder.time.setText("Over.....");
        }
    }*/

}





