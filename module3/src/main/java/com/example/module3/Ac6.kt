package com.example.module3

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import org.simple.eventbus.EventBus

class Ac6 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ac6)

        var tev = findViewById<View>(R.id.tv)
        tev.setOnClickListener {
            Log.d("11", "" + it.x)

            EventBus.getDefault().post("i'm module3", "m3")
        }

    }
}