package com.example.vipul.hireforwork;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.mbms.MbmsErrors;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainProfil2Activity extends AppCompatActivity implements View.OnClickListener {
 public Button updateAccountSetting,savedata,nextp;
 public EditText userText,status,agey,emailidy,contryy,Exprance,Otherw,Address,Profession;
 public String item_name,addre,namey,phy,agy,emy,cony,Spinneritems,exp,otherworks,RadioWorkres,r1s,r2s,abc,profess,genderstring,workerstringor;
 public TextView t,t1,t3;
 public RadioButton r1,r2,r3,r4;
 public Spinner ss,con;
 public RadioGroup radioButton,radioButton_Gender;
 public static int RESULT_LOAD_IMG = 1;
 public String imgDecodableString;
 public CircleImageView userProfilImage;
 Bitmap imag;
 String mobile,storeimage;
    DatabaseHelper mDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_profil2);
       // savedata=(Button)findViewById(R.id.save);
        nextp=(Button)findViewById(R.id.Nextpage);

        updateAccountSetting = (Button) findViewById(R.id.save);
        userText = (EditText) findViewById(R.id.uname);
        status = (EditText) findViewById(R.id.phno);
        agey=(EditText) findViewById(R.id.Age);
        emailidy=(EditText) findViewById(R.id.EmailId);
        Address=(EditText)findViewById(R.id.Address);
        con=(Spinner) findViewById(R.id.Country);
        Exprance=(EditText)findViewById(R.id.Exp);
        Otherw=(EditText)findViewById(R.id.Other);
        Profession=(EditText)findViewById(R.id.Other);

        radioButton=(RadioGroup)findViewById(R.id.G_Id);
        radioButton_Gender=(RadioGroup)findViewById(R.id.W_id);

        profess=Profession.getText().toString().trim();
        phy=status.getText().toString().trim();
        agy=agey.getText().toString().trim();
        emy=emailidy.getText().toString().trim();
        //cony=contryy.getText().toString().trim();
        exp=Exprance.getText().toString().trim();
        otherworks=Otherw.getText().toString().trim();
        addre=Address.getText().toString().trim();

        String[] items1 =new String[]{"India","China","Japan","Germany","United States","France","United Kingdom","Brazil","Italy","Canada","South Korea","Russia","Australia","Spain","Mexico",
                "Indonesia","Turkey","Kingdom of the Netherlands","Saudi Arbia","Switzerland","Argentina","Sweden","Thailand","Poland","Belgium","Nigeria","Iran","Austria",
                "Egypt","Norway","United Arab Emirates","Phillippines","Israel","Ireland","Malaysia","South Africa","Colombia","Singapore","Bangladesh","Chile","Finland",
                "Portugal","Peru","Vietnam","New Zealand","Venezuela","Romania","Czench Republic","Greece"};
        ArrayAdapter<String> adapter1=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,items1);
        con.setAdapter(adapter1);


        Intent intent = getIntent();
        mobile = intent.getStringExtra("mobile");
        userProfilImage=(CircleImageView)findViewById(R.id.profile_image);
       // imag=userProfilImage.getDrawable().getConstantState();
        userProfilImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create intent to Open Image applications like Gallery, Google Photos
                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
            }


        });



        updateAccountSetting = (Button) findViewById(R.id.save);
        updateAccountSetting.setOnClickListener(this);

        status=(EditText) findViewById(R.id.phno);
        item_name=getIntent().getStringExtra("mobile");
        status.setText(item_name);
        RadioButton r1=(RadioButton)findViewById(R.id.radio_U);
        r1s=r1.getText().toString();
        r1.setOnClickListener(this);
        RadioButton r2=(RadioButton)findViewById(R.id.radio_W);
        r2s=r2.getText().toString();
        r2.setOnClickListener(this);
        t =(TextView)findViewById(R.id.Enter_Wo);
        t1=(TextView)findViewById(R.id.Enter_exp);
        t3=(TextView)findViewById(R.id.Enter_Other);
        ss=(Spinner) findViewById(R.id.Spinner_wo);
        radioButton.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                r3=(RadioButton)findViewById(checkedId);
                Toast.makeText(getBaseContext(),r3.getText(),Toast.LENGTH_SHORT).show();
                genderstring=r3.getText().toString();
            }
        });
        radioButton_Gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
              r4=(RadioButton)findViewById(checkedId);
               RadioWorkres=r4.getText().toString();
              Toast.makeText(getBaseContext(),RadioWorkres,Toast.LENGTH_SHORT).show();
              workerstringor=r4.getText().toString();
               if(r2s==RadioWorkres){
                   abc="sorry";
               }else {
                   abc="ok";
               }

            }
        });
        mDatabaseHelper = new DatabaseHelper(this);
        AddData();
        nextp.setOnClickListener(this);
    }

    private void AddData() {
        updateAccountSetting.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        agy=agey.getText().toString();
                        emy=emailidy.getText().toString();
                        //cony=contryy.getText().toString();
                        namey =userText.getText().toString();
                        exp=Exprance.getText().toString();
                        otherworks=Otherw.getText().toString();
                        addre=Address.getText().toString();
                        profess=Profession.getText().toString();

                        if(namey.matches("")){
                            userText.setError("Please enter name");
                        }
                        else if(agy.matches("")){
                            agey.setError("Please enter age");
                        }else if(emy.matches("")){
                            emailidy.setError("Please enter email");
                        }else if(addre.matches("")){
                            Address.setError("Please enter Address");
                        }else if(abc=="sorry"){
                            if(exp.matches("")){
                                Exprance.setError("Please enter Experience");
                            }
                            if(profess.matches("")){
                                Profession.setError("Please enter professional");
                            }
                            abc="hii";
                        } else {
                            cony="India";
                            boolean isInserted = mDatabaseHelper.insertData(namey,item_name,agy,genderstring,emy,cony,addre,workerstringor);
                            if(isInserted == true) {
                                Toast.makeText(MainProfil2Activity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                            }else {
                                Toast.makeText(MainProfil2Activity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                            }
                            nextp.setVisibility(View.VISIBLE);
                        }
                    }
                }
        );
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            // When an Image is picked
            if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK
                    && null != data) {
                // Get the Image from data

                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };

                // Get the cursor
                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imgDecodableString = cursor.getString(columnIndex);
                cursor.close();

                CircleImageView imgView = (CircleImageView) findViewById(R.id.profile_image);
                // Set the Image in ImageView after decoding the String
                imgView.setImageURI(selectedImage);
               // storeimage=
                //imgView.setImageBitmap(BitmapFactory
                  //      .decodeFile(imgDecodableString));

            } else {
                Toast.makeText(this, "You haven't picked Image",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
                    .show();
        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.Nextpage:
                Intent ve=new Intent(MainProfil2Activity.this,MainActivity.class);
                ve.putExtra("module","login");
                startActivity(ve);
                finish();
                break;
            case R.id.radio_U:
               // Toast.makeText(getApplicationContext(),"Costumer",Toast.LENGTH_SHORT).show();
                t.setVisibility(View.GONE);
                ss.setVisibility(View.GONE);
                t1.setVisibility(View.GONE);
                Exprance.setVisibility(View.GONE);
                t3.setVisibility(View.GONE);
                Otherw.setVisibility(View.GONE);
                break;
            case R.id.radio_W:
               // Toast.makeText(getApplicationContext(),"Worker",Toast.LENGTH_SHORT).show();
                t.setVisibility(View.VISIBLE);
                ss.setVisibility(View.VISIBLE);
                String[] items =new String[]{"Plumber","ele","house","Other"};
                ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,items);
                ss.setAdapter(adapter);
                t1.setVisibility(View.VISIBLE);
                Exprance.setVisibility(View.VISIBLE);

                ss.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selI=parent.getItemAtPosition(position).toString();
                        if(selI.equals("Other"))
                        {
                            t3.setVisibility(View.VISIBLE);
                            Otherw.setVisibility(View.VISIBLE);
                        }else {
                            t3.setVisibility(View.GONE);
                            Otherw.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            default:
                break;
        }
    }
}
