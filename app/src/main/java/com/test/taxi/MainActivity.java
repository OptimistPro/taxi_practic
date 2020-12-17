package com.test.taxi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView(); //скрыть панель навигации
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION

                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                ;
        decorView.setSystemUiVisibility(uiOptions);
        setContentView(R.layout.splashlayout);


        new Handler().postDelayed(new Runnable(){
            @Override
                    public void run(){
                Intent inten = new Intent(MainActivity.this,signin.class);
                startActivity(inten);
                finish();
            }
        },2*1000);
    }
}