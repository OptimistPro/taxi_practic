package com.test.taxi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class history_fragment extends Fragment {
    public static history_fragment newInstance(String someInt,String someInt2) {
        history_fragment catFragment = new history_fragment();
        Bundle args = new Bundle();
        args.putString("someInt", someInt);
        catFragment.setArguments(args);
       args.putString("someInt2", someInt2);
       catFragment.setArguments(args);
        return catFragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_history_fragment, container, false);

        TextView t = view.findViewById(R.id.time_text);
        t.setText(getArguments().getString("someInt", "5 min"));

       TextView t2 = view.findViewById(R.id.dolod_text);
        t2.setText(getArguments().getString("someInt2", "$15"));

        return view;
    }
}