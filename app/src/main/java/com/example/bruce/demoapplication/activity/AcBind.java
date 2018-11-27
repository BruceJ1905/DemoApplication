package com.example.bruce.demoapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;

import com.example.annotation.DIActivity;
import com.example.annotation.DIView;
import com.example.bruce.demoapplication.R;
import com.mytool.HelloWorld;

@DIActivity
//@MyAnnotation
public class AcBind extends Activity {

    @DIView(R.id.button4)
    public Button button;
    @DIView(R.id.imageView3)
    public ImageView imageView;
    @DIView(R.id.calendarView)
    public CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_bind);

        DIAcBind.bindView(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendarView.setVisibility(View.GONE);
                HelloWorld.main(new String[] { "111" });
            }
        });
    }
}
