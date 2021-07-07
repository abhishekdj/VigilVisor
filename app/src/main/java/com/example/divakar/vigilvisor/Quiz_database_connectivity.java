package com.example.divakar.vigilvisor;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by DIVAKAR on 03-11-2016.
 */

class Quiz_database_connectivity extends AsyncTask<String ,Void ,String> {
    Context ctx;
    AlertDialog alertDialog;
    Quiz_database_connectivity(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        alertDialog=new AlertDialog.Builder(ctx).create();
    }

    protected String doInBackground(String... params) {
        String log_url = "http://10.0.2.2/AndroidApp/Quiz.php";
        System.out.print("success");
        String method = params[0];
        if (method.equals("GO")) {
            String Question = params[1];
            String Option1 = params[2];
            String Option2 = params[3];
            String Option3 = params[4];
            String Option4 = params[5];
            String Answer = params[6];

            try {
                URL url = new URL(log_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                System.out.print("success");
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream os = httpURLConnection.getOutputStream();
                System.out.print("success");
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data = URLEncoder.encode("user_question", "UTF-8") + "=" + URLEncoder.encode(Question, "UTF-8") + "&" +
                        URLEncoder.encode("user_opt1", "UTF-8") + "=" + URLEncoder.encode(Option1, "UTF-8")+"&"+
                        URLEncoder.encode("user_opt2", "UTF-8") + "=" + URLEncoder.encode(Option2, "UTF-8")+"&"+
                        URLEncoder.encode("user_opt3", "UTF-8") + "=" + URLEncoder.encode(Option3, "UTF-8")+"&"+
                        URLEncoder.encode("user_opt4", "UTF-8") + "=" + URLEncoder.encode(Option4, "UTF-8")+"&"+
                        URLEncoder.encode("user_ans", "UTF-8") + "=" + URLEncoder.encode(Answer, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();
                InputStream IS = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(IS, "iso-8859-1"));
                String response = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    response += line;
                }
                bufferedReader.close();
                IS.close();
                httpURLConnection.disconnect();
                return response;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    protected void onPostExecute(String result) {

        Toast.makeText(ctx, "Question Uploaded Successfully...", Toast.LENGTH_LONG).show();
    }


}
