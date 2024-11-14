package com.example.sharedprefapp;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {


    TextView tvName, tvPass, tvEmail;
    Button btnLogout;
    SharedPreferences sharedPref;
    String myPreferences = "MyPrefs";
    private static final String name = "nameKey";
    private static final String password = "passKey";
    private static final String email = "emailKey";
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvName = findViewById(R.id.name1);
        tvPass = findViewById(R.id.pass1);
        tvEmail = findViewById(R.id.email1);
        btnLogout = findViewById(R.id.btnLog);

        sharedPref = getSharedPreferences(myPreferences,MODE_PRIVATE);
        String n = sharedPref.getString(name, null);
        String pw = sharedPref.getString(password, null);
        String e = sharedPref.getString(email, null);


        if (n !=null || pw !=null || e !=null){
            tvName.setText("Name: "+n);
            tvPass.setText("Password: "+pw);
            tvEmail.setText("Email: "+e);
        }


        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.clear();
                editor.apply();
                Toast.makeText(SecondActivity.this,"Logout Successfully",Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}