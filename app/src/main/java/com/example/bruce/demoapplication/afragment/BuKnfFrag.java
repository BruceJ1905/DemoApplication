package com.example.bruce.demoapplication.afragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.bruce.demoapplication.R;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BuKnfFrag extends Fragment {

    View view;
    int r;

    @BindView(R.id.button3)
    @Nullable Button button3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_buknf, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button3.setOnClickListener(v -> {
            r = new Random().nextInt();
            button3.setText("RAN : " + r);
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("bruce", "onSaveInstanceState " + r);
        outState.putInt("r", r);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) {
            r = savedInstanceState.getInt("r");
        }
        if (button3 != null) {
            button3.setText("RAN : " + r);
        }
        Log.d("bruce", "onViewStateRestored " + r);

    }
}
