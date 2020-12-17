package com.test.taxi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.common.api.Response;

import java.net.URL;

public class signin extends AppCompatActivity {

    //class zaprs extends
    //protected String doInBackground(URL... urls){
    //    String response = null;
//
   //     try {
    //        response=getResponseFormURL(urls[0]);
   //     }
   // }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


        TextView button = findViewById(R.id.textView3);
        View.OnTouchListener st = new View.OnTouchListener(){
            public boolean onTouch(View view, MotionEvent event)
            {
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    Intent intent = new Intent(signin.this,signup.class);
                    startActivity(intent);
                }
                return true;
            }

        };
        button.setOnTouchListener(st);


        Button button2 = findViewById(R.id.vxod);
        View.OnTouchListener st2 = new View.OnTouchListener(){
            public boolean onTouch(View view, MotionEvent event)
            {
                if (event.getAction()==MotionEvent.ACTION_DOWN){

                    //нажатие


                    Intent intent = new Intent(signin.this,startmap.class);
                    startActivity(intent);



                }
                return true;

            }

        };
        button2.setOnTouchListener(st2);

    }
}