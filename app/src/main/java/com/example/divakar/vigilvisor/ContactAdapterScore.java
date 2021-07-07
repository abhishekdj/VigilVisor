package com.example.divakar.vigilvisor;

import android.content.Context;
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

/**
 * Created by DIVAKAR on 19-11-2016.
 */

public class ContactAdapterScore extends ArrayAdapter {

    List list=new ArrayList();
    public ContactAdapterScore (Context context, int resource) {
        super(context, resource);
    }


    public void add(ContactScore object) {
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
        ContactHolder contactHolder;
        if(row==null)
        {
            LayoutInflater layoutInflater=(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.row_score,parent,false);
            contactHolder= new ContactAdapterScore.ContactHolder();
            contactHolder.tx_Prn=(TextView) row.findViewById(R.id.textView17);
            contactHolder.tx_Score=(TextView) row.findViewById(R.id.textView18);
            //contactHolder.optionA=(RadioButton)row.findViewById(R.id.optionA);
            //contactHolder.optionB=(RadioButton)row.findViewById(R.id.optionB);

            row.setTag(contactHolder);
        }
        else
        {
            contactHolder =(ContactAdapterScore.ContactHolder) row.getTag();

        }
        ContactScore contact = (ContactScore) this.getItem(position);
        contactHolder.tx_Prn.setText(contact.getPRN());
        contactHolder.tx_Score.setText(contact.getScore());
        //contactHolder.optionA.setText("YES");
        //contactHolder.optionB.setText("NO");
        Log.e("err", String.valueOf(list.size()));

        return row;
    }
    static class ContactHolder
    {
        TextView tx_Prn;
  //      RadioButton optionA;
//        RadioButton optionB;
         TextView tx_Score;
    }

}
