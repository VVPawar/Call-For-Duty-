package com.example.vipul.hireforwork;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    Context context;
    List<RowItem> rowItems;


    CustomAdapter(Context context, List<RowItem> rowItems){
        this.context=context;
        this.rowItems=rowItems;
    }

    @Override
    public int getCount(){return rowItems.size();}

    @Override
    public Object getItem(int position){return rowItems.get(position);}

    @Override
    public long getItemId(int position){return rowItems.indexOf(getItem(position));}

    private class ViewHolder{
        ImageView item_pic;
        TextView item_name;
        TextView description;
        ImageView item_rat;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final ViewHolder holder;
        if (convertView==null){
            LayoutInflater mInflater=(LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView= mInflater.inflate(R.layout.list_item,null);
            holder=new ViewHolder();

            holder.item_name=(TextView)convertView.findViewById(R.id.item_name);
            holder.item_pic=(ImageView) convertView.findViewById(R.id.item_pic);
            holder.description=(TextView)convertView.findViewById(R.id.item_Description);
            holder.item_rat=(ImageView) convertView.findViewById(R.id.item_rat);
            convertView.setTag(holder);
        }else{
            holder=(ViewHolder) convertView.getTag();
        }
        RowItem row_pos = rowItems.get(position);
        holder.item_pic.setImageResource(row_pos.getItem_pic_id());
        holder.item_name.setText(row_pos.getItem_name());
        holder.description.setText(row_pos.getDescription());
        holder.item_rat.setImageResource(row_pos.getItem_rat_id());
        return convertView;
    }

}
