package com.example.bruce.demoapplication.activity

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.widget.FrameLayout

class Ac3 : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var fl = FrameLayout(this)
        fl.setBackgroundColor(Color.BLUE)
        setContentView(fl)
    }


}