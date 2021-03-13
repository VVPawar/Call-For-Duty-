package com.example.vipul.hireforwork;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter_Setting extends BaseAdapter {
    Context context;
    String [] rooms;
    public  CustomAdapter_Setting(Context c){
        context=c;
        Resources res =c.getResources();
        rooms=res.getStringArray(R.array.setting_string);
    }
    @Override
    public int getCount() {
        return rooms.length;
    }

    @Override
    public Object getItem(int position) {
        return rooms[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.single_row,parent,false);
        TextView txt =(TextView)view.findViewById(R.id.item_Satting);
        String temp =rooms[position];
        txt.setText(temp);
        return view;
    }
}
