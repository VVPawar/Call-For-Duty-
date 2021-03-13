package com.example.vipul.hireforwork;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Workears extends AppCompatActivity implements View.OnClickListener{
ImageView item_pics;
    ImageView item_rate;
TextView name1,item_typen;
String item_name,item_type;
int item_pic,item_rat;
String phone="9595979680";
    ImageButton Callph,Chatph,Locationph,Rateph;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workears);
        item_pics=(ImageView)findViewById(R.id.item_pic);

        item_pic=getIntent().getIntExtra("item_pic",-1);
        item_pics.setImageResource(item_pic);
        name1=(TextView)findViewById(R.id.item_name);
        item_name=getIntent().getStringExtra("item_name");
        name1.setText(item_name);
        item_typen=(TextView)findViewById(R.id.item_typen);
        item_type=getIntent().getStringExtra("item_type");
        item_typen.setText(item_type);

        item_rate=(ImageView)findViewById(R.id.item_Ra);
        item_rat=getIntent().getIntExtra("item_rat",-1);
        item_rate.setImageResource(item_rat);
        Callph=(ImageButton)findViewById(R.id.Callid);
        Callph.setOnClickListener(this);
        Chatph=(ImageButton)findViewById(R.id.Chatid);
        Chatph.setOnClickListener(this);
        Locationph=(ImageButton)findViewById(R.id.Locid);
        Locationph.setOnClickListener(this);
        Rateph=(ImageButton)findViewById(R.id.Ratid);
        Rateph.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.Callid:
                Toast.makeText(this,"Call",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                String temp = "tel:" + phone;
                intent.setData(Uri.parse(temp));

                startActivity(intent);

                break;

            case R.id.Chatid:
                Toast.makeText(this,"Chat",Toast.LENGTH_SHORT).show();
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO,
                        Uri.parse("sms:9595979680"));
                smsIntent.putExtra("sms_body", "Hello");
                startActivity(smsIntent);
                break;
            case R.id.Locid:
                Toast.makeText(this,"Location",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Ratid:
                Toast.makeText(this,"Rating",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
