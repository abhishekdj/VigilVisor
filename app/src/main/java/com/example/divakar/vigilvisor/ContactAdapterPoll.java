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
 * Created by DIVAKAR on 08-11-2016.
 */

public class ContactAdapterPoll extends ArrayAdapter {

    List list=new ArrayList();
    public ContactAdapterPoll (Context context, int resource) {
        super(context, resource);
    }


    public void add(ContactsPoll object) {
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
        ContactAdapterPoll.ContactHolder contactHolder;
        if(row==null)
        {
            LayoutInflater layoutInflater=(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.row_layout_poll,parent,false);
            contactHolder=new ContactAdapterPoll.ContactHolder();
            contactHolder.tx_Question=(TextView) row.findViewById(R.id.tx_name);
           contactHolder.optionA=(RadioButton)row.findViewById(R.id.optionA);
            contactHolder.optionB=(RadioButton)row.findViewById(R.id.optionB);

            row.setTag(contactHolder);
        }
        else
        {
            contactHolder =(ContactAdapterPoll.ContactHolder) row.getTag();

        }
        ContactsPoll contact = (ContactsPoll) this.getItem(position);
        contactHolder.tx_Question.setText(contact.getQuestion());
        contactHolder.optionA.setText("YES");
        contactHolder.optionB.setText("NO");
        Log.e("err", String.valueOf(list.size()));

        return row;
    }
    static class ContactHolder
    {
        TextView tx_Question;
        RadioButton optionA;
        RadioButton optionB;

    }


}
