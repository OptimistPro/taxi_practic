package com.test.taxi;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;


public class veical_book extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View t= inflater.inflate(R.layout.fragment_veical_book, container, false);

        Button button2 = t.findViewById(R.id.bookbut);
        View.OnTouchListener st2 = new View.OnTouchListener(){
            public boolean onTouch(View view, MotionEvent event)
            {
                if (event.getAction()==MotionEvent.ACTION_DOWN){

                    //нажатие


                    Intent intent = new Intent(getActivity(),timer_taxi.class);
                    startActivity(intent);



                }
                return true;

            }

        };
        button2.setOnTouchListener(st2);


        return t;
    }

}