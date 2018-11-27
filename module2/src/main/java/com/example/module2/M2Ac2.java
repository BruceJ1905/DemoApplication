package com.example.module2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class M2Ac2 extends AppCompatActivity {

    @BindView(R2.id.module2_button2)
    Button button;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m2_ac2);
        ButterKnife.bind(this);

        button.setOnClickListener( v -> {
            button.setText("r" + new Random().nextInt());
        });
    }
}
