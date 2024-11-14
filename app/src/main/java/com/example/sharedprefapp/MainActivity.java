package com.example.sharedprefapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText et1, et2, et3;
    Button bt;
    SharedPreferences sharedPref;
    String myPreferences = "MyPrefs";
    private static final String name = "nameKey";
    private static final String password = "passKey";
    private static final String email = "emailKey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.editName);
        et2 = (EditText) findViewById(R.id.editPassword);
        et3 = (EditText) findViewById(R.id.editEmail);

        sharedPref = getSharedPreferences(myPreferences,MODE_PRIVATE);

        String n = sharedPref.getString(name, null);

        if (n !=null){
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            startActivity(intent);
        }


        bt = (Button) findViewById(R.id.btnSave);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPref.edit();

                editor.putString(name,et1.getText().toString());
                editor.putString(password,et2.getText().toString());
                editor.putString(email,et3.getText().toString());
                editor.apply();


                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);

                Toast.makeText(MainActivity.this,"Save Successfully",Toast.LENGTH_LONG).show();

            }
        });


    }
}