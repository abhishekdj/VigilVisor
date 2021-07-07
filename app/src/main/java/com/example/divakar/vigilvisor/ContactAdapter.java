package com.example.divakar.vigilvisor;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by DIVAKAR on 06-11-2016.
 */

  class ContactAdapter extends ArrayAdapter {
    ContactHolder contactHolder;
    List list=new ArrayList();
    public ContactAdapter(Context context, int resource) {
        super(context, resource);
    }


    public void add(Contacts object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();

    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

       View row;
        row=convertView;

        if(row==null)
        {
            LayoutInflater layoutInflater=(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.row_layout,parent,false);
            contactHolder=new ContactHolder();
            contactHolder.tx_Question=(TextView) row.findViewById(R.id.tx_name);
            contactHolder.optionA=(RadioButton)row.findViewById(R.id.optionA);
            contactHolder.optionB=(RadioButton)row.findViewById(R.id.optionB);
            contactHolder.optionC=(RadioButton)row.findViewById(R.id.optionC);


            contactHolder.optionD=(RadioButton)row.findViewById(R.id.optionD);

            row.setTag(contactHolder);
        }
        else
        {
            contactHolder =(ContactHolder) row.getTag();

        }
        Contacts contact = (Contacts) this.getItem(position);
        contactHolder.tx_Question.setText(contact.getQuestion());
        contactHolder.optionA.setText(contact.getOptionA());
        contactHolder.optionB.setText(contact.getOptionB());
        contactHolder.optionC.setText(contact.getOptionC());
        contactHolder.optionD.setText(contact.getOptionD());

      //  Log.e("err", String.valueOf(list.size()));
       // final CounterClass timer=new CounterClass(180000,1000);

        return row;
    }
    static class ContactHolder
    {
        TextView tx_Question;
        RadioButton optionA;
        RadioButton optionB;
        RadioButton optionC;
        RadioButton optionD;

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
    /*    public CounterClass(long millisInFuture, long countDownInterval) {
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
            contactHolder.time.setText(hms);
        }

        @Override
        public void onFinish() {
            contactHolder.time.setText("Over.....");
        }
    }*/

}
