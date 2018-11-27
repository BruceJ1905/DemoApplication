package com.example.module4

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_ac7.*
import org.simple.eventbus.EventBus

class Ac7 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ac7)

        button.setOnClickListener {
            EventBus.getDefault().post("i'm module3", "m3")

        }

    }
}
