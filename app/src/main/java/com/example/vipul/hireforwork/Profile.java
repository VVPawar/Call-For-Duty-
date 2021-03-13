package com.example.vipul.hireforwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class Profile extends AppCompatActivity {
    //item_name=getIntent().getStringExtra("mobile");
    //        status.setText(item_name);
    public String mobile1,mobile2,mobile3,mobile4,mobile5,mobile6,mobile7,mobile8;
    public EditText e1,e2,e3,e4,e5,e6,e7,e8;
    public CircleImageView userProfilImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        e1=(EditText)findViewById(R.id.uname2);
        e2=(EditText)findViewById(R.id.phno2);
        e3=(EditText)findViewById(R.id.Age2);
        e4=(EditText)findViewById(R.id.G_Id2);
        e5=(EditText)findViewById(R.id.EmailId2);
        e6=(EditText)findViewById(R.id.Country2);
        e7=(EditText)findViewById(R.id.Address2);
        e8=(EditText)findViewById(R.id.W_id2);
        mobile1 = getIntent().getStringExtra("mobile1");
        mobile2 = getIntent().getStringExtra("mobile2");
        mobile3 = getIntent().getStringExtra("mobile3");
        mobile4 = getIntent().getStringExtra("mobile4");
        mobile5 = getIntent().getStringExtra("mobile5");
        mobile6 = getIntent().getStringExtra("mobile6");
        mobile7 = getIntent().getStringExtra("mobile7");
        mobile8 = getIntent().getStringExtra("mobile8");
        e1.setText(mobile1);
        e2.setText(mobile2);
        e3.setText(mobile3);
        e4.setText(mobile4);
        e5.setText(mobile5);
        e6.setText(mobile6);
        e7.setText(mobile7);
        e8.setText(mobile8);
    }
}
