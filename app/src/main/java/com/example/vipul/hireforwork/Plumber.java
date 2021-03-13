package com.example.vipul.hireforwork;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Plumber extends AppCompatActivity implements AdapterView.OnItemClickListener {

    String module;
    String[] item_names,pass1;
    TypedArray item_pics,item_rate;
    String[] description;

    List<RowItem> rowItems;
    ListView mylistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plumber);
        mylistview=(ListView) findViewById(R.id.list);


        module= getIntent().getStringExtra("module");

        rowItems= new ArrayList<RowItem>();

        if (module.equals("vowels")) {
            item_names = getResources().getStringArray(R.array.vowels_item_names);
            item_pics = getResources().obtainTypedArray(R.array.vowels_item_pics);
            description = getResources().getStringArray(R.array.vowels_item_description);
            item_rate = getResources().obtainTypedArray(R.array.item_rates);

        }else  if (module.equals("consonants")) {
            item_names = getResources().getStringArray(R.array.item_names);
            item_pics = getResources().obtainTypedArray(R.array.item_pics);
            description = getResources().getStringArray(R.array.item_description);
            item_rate = getResources().obtainTypedArray(R.array.item_rates);
        }
        for(int i=0;i<item_names.length;i++){
            RowItem item=new RowItem(item_names[i],item_pics.getResourceId(i,-1),description[i],item_rate.getResourceId(i,-1));
            rowItems.add(item);
        }
        CustomAdapter adapter=new CustomAdapter(this,rowItems);
        mylistview.setAdapter(adapter);
        mylistview.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String item_name=rowItems.get(position).getItem_name();
        int item_pic=rowItems.get(position).getItem_pic_id();
        int item_rat=rowItems.get(position).getItem_rat_id();
        String item_type= rowItems.get(position).getDescription();
        //Toast.makeText(getApplicationContext(),""+item_name,Toast.LENGTH_SHORT).show();
        Intent iw= new Intent(Plumber.this,Workears.class);
        iw.putExtra("item_name",item_name);
        iw.putExtra("item_pic",item_pic);
        iw.putExtra("item_type",item_type);
        iw.putExtra("item_rat",item_rat);
        startActivity(iw);
    }
}
