package com.example.vipul.hireforwork;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Authentication extends AppCompatActivity {
    private EditText editTextMobile;
    
    VerifyPhoneActivity vf=new VerifyPhoneActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        editTextMobile = findViewById(R.id.editTextMobile);

        if(vf.aut.equals("ok"))
        {
            Intent i = new Intent(Authentication.this,MainActivity.class);
            startActivity(i);
            finish();
        }
        else {
            findViewById(R.id.buttonContinue).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String mobile = editTextMobile.getText().toString().trim();
                    if (mobile.isEmpty() || mobile.length() < 10) {
                        editTextMobile.setError("Enter a valid mobile");
                        editTextMobile.requestFocus();
                        return;
                    }
                    Intent intent = new Intent(Authentication.this, VerifyPhoneActivity.class);
                    intent.putExtra("mobile", mobile);
                    startActivity(intent);
                    finish();

                }
            });
        }
    }
}
