package com.test.taxi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;

public class timer_taxi extends AppCompatActivity {
    boolean start_p = false;
    Date ty = new Date(1212121212121L);
    Thread t;
    boolean f = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_taxi);

        Button button2 = findViewById(R.id.buttony);
        View.OnTouchListener st2 = new View.OnTouchListener(){
            public boolean onTouch(View view, MotionEvent event)
            {
                if (event.getAction()==MotionEvent.ACTION_DOWN){

                    //нажатие


                    Intent intent = new Intent(timer_taxi.this,startmap.class);
                    startActivity(intent);



                }
                return true;

            }

        };
        button2.setOnTouchListener(st2);

        final Button button = findViewById(R.id.button);
        View.OnTouchListener st = new View.OnTouchListener(){
            public boolean onTouch(View view, MotionEvent event)
            {
                if (event.getAction()==MotionEvent.ACTION_DOWN){

                    //нажатие
                    if (f){
                    f=false;
                    button.setText("Play");
                    }else{
                        f=true;
                        button.setText("Stop");
                    }

                }
                return true;

            }

        };
        button.setOnTouchListener(st);






        ty.setHours(0);
        ty.setMinutes(15);
        ty.setSeconds(0);

        t = new Thread() {

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (f) {

                                    if (ty.getHours() != 0 || ty.getMinutes() != 0 || ty.getSeconds() != 0) {
                                        ty.setSeconds(ty.getSeconds() - 1);
                                    }

                                    String hous = "";
                                    String min = "";
                                    String sek = "";

                                    if (ty.getHours() < 10) {
                                        hous = "0" + Integer.toString(ty.getHours());
                                    } else {
                                        hous = Integer.toString(ty.getHours());
                                    }

                                    if (ty.getMinutes() < 10) {
                                        min = "0" + Integer.toString(ty.getMinutes());
                                    } else {
                                        min = Integer.toString(ty.getMinutes());
                                    }

                                    if (ty.getSeconds() < 10) {
                                        sek = "0" + Integer.toString(ty.getSeconds());
                                    } else {
                                        sek = Integer.toString(ty.getSeconds());
                                    }
                                    TextView tm = findViewById(R.id.time_ot);
                                    tm.setText(hous + ":" + min + ":" + sek);
                                }
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        t.start();







    }
}