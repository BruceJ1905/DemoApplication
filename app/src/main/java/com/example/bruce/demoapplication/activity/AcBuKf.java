package com.example.bruce.demoapplication.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.bruce.demoapplication.R;
import com.example.bruce.demoapplication.afragment.BuKnfFrag;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AcBuKf extends AppCompatActivity {

    BuKnfFrag buKnfFrag;

    @BindView(R.id.button) Button button;
    @BindView(R.id.button2) Button button2;
    @BindView(R.id.button3) Button button3;
    @BindView(R.id.container) FrameLayout frameLayout;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_buknf);

        ButterKnife.bind(this);

        button.setOnClickListener(v -> {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//            if (buKnfFrag != null) {
//                transaction.remove(buKnfFrag);
//            }

            buKnfFrag = new BuKnfFrag();

            transaction.add(R.id.container, buKnfFrag);
            transaction.addToBackStack("f1");
            transaction.commit();

        });

        button2.setOnClickListener(v -> {
            getSupportFragmentManager().popBackStack();
        });

        button3.setOnClickListener(v -> {
            int childCnt = frameLayout.getChildCount();
            Log.d("bruce", "" + childCnt);
        });

    }


}
