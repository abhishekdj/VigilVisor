package com.example.divakar.vigilvisor;
import android.*;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedInputStream;
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
 * Created by DIVAKAR on 22-10-2016.
 */

class Student_downloader extends AsyncTask<Void ,Integer ,String> {
    Context c;
    String address= "http://10.0.2.2/AndroidApp/student_poll1.php";;
    ListView lv;
    ProgressDialog pd;
    public Student_downloader(Context c,String address,ListView lv) {
        this.c = c;
        this.lv=lv;
        this.address=address;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd=new ProgressDialog(c);
        pd.setTitle("Fetch Data");
        pd.setMessage("Fetching Data...Please wait ");
    }

    protected String doInBackground(Void... params) {
        String data=downloadData();
        return data;
    }

    /*protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }
*/
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        pd.dismiss();
        if(s != null)
        {
            Parser p=new Parser(c,s,lv);
            p.execute();

        }else
        {
            Toast.makeText(c,"Unable to download data",Toast.LENGTH_SHORT).show();
        }
    }
    private String downloadData()  {
        //connect and get a stream
        InputStream is=null;
        String line =null;
        Toast.makeText(c,"kkjchjdjhdse",Toast.LENGTH_SHORT).show();

        try{


    URL url=new URL("http://10.0.2.2/AndroidApp/student_poll1.php");
        HttpURLConnection con= (HttpURLConnection) url.openConnection();

           is=new BufferedInputStream(con.getInputStream());
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            StringBuffer sb=new StringBuffer();


            if(br != null) {
                while ((line=br.readLine()) != null) {
                    sb.append(line+"n");
                }
            }else {
                return null;
            }

            return sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            if(is != null)
            {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
}