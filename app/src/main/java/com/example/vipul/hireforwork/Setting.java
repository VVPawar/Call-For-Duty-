package com.example.vipul.hireforwork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ListView listView=(ListView)findViewById(R.id.list1);
        listView.setAdapter(new CustomAdapter_Setting(this));
    }
}
