package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
public static final String TAG="MainActivity";
    private CountDownTimer timer;
    TextView tvTimerValue , tvTimerCompletedText;
    int currentTimerValue=0;
    TextView question,title;
    Button hermonie,ginny;
    ImageView imageView,imageView3;
    Intent i;
    String s="doğru cevap";
    String a="yanlış cevap";
    String c=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init_UI();

        currentTimerValue=10;

    }
    private void timerStart(int second){
        timer=new CountDownTimer(second*1000,1000) {
            @Override
            public void onTick(long l) {
                currentTimerValue=(int)l/1000;
                tvTimerValue.setText(""+l);

            }

            @Override
            public void onFinish() {
                tvTimerValue.setText("0");
                tvTimerCompletedText.setText("sayaç tamamlandı");




                startActivity(i);

            }
        };
        timer.start();

    }

    private void init_UI() {
        Context self=this;
        i=new Intent(self,MainActivity2.class);
        question=(TextView)findViewById(R.id.question);
        title=(TextView)findViewById(R.id.title);
        hermonie=(Button) findViewById(R.id.hermonie);
        ginny=(Button) findViewById(R.id.ginny);

        tvTimerValue=(TextView) findViewById(R.id.textView3);
        tvTimerCompletedText=(TextView)findViewById(R.id.textView4);
        i.putExtra("isim",c);
        hermonie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                i.putExtra("isim", s);


            }
        });
        ginny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                i.putExtra("isim",a);

            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
        timerStart(currentTimerValue);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
        timer.cancel();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");

    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d(TAG,"onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }
}