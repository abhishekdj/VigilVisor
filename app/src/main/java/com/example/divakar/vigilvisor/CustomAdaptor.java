package com.example.divakar.vigilvisor;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by DIVAKAR on 09-11-2016.
 */

public class CustomAdaptor extends ArrayAdapter<Model> {
    private final Activity context;

    private final List<Model> list;

    public CustomAdaptor(Activity context, List<Model> list) {
        super(context, R.layout.row_layout, list);
        this.context = context;
        this.list = list;
    }


    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        // Creating a view of row.
        View rowView = inflater.inflate(R.layout.row_layout, parent, false);

        TextView textView1 = (TextView) rowView.findViewById(R.id.tx_name);
        RadioGroup radioGroup=(RadioGroup) rowView.findViewById(R.id.radioGroup);
        RadioButton OptionA = (RadioButton) rowView.findViewById(R.id.optionA);
        RadioButton OptionB = (RadioButton) rowView.findViewById(R.id.optionB);
        RadioButton OptionC = (RadioButton) rowView.findViewById(R.id.optionC);
        RadioButton OptionD = (RadioButton) rowView.findViewById(R.id.optionD);

     
            return  rowView;
        }
    }