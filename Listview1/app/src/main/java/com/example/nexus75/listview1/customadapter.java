package com.example.nexus75.listview1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.zip.Inflater;

/**
 * Created by NEXUS75 on 4/16/2016.
 */
public class customadapter extends ArrayAdapter<String>{
    private final Activity context;
    private final String[] names;
    private final String[] description;
    public customadapter(Activity context,String[] names,String[] description){
        super(context,R.layout.item_row,names);
        this.context=context;
        this.names=names;
        this.description=description;
    }
    @Override
    public  View getView(int position,View view,ViewGroup parent){
        LayoutInflater inflater=context.getLayoutInflater();
        View row=inflater.inflate(R.layout.item_row, null, true);
        TextView _name=(TextView)row.findViewById(R.id.id);
        TextView _descript=(TextView)row.findViewById(R.id.detail);
        _name.setText(names[position]);
        _descript.setText(description[position]);
        return row;
    }

}
