package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
Intent i;
String s;
TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tv=(TextView)findViewById(R.id.textView);

        i=getIntent();
        Bundle b =new Bundle();

        b=getIntent().getExtras();



            s = b.getString("isim");



           ;

        }



    @Override
    protected void onResume() {
        super.onResume();
        tv.setText(s);



    }

}