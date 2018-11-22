package com.example.bruce.demoapplication.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import com.example.bruce.demoapplication.R
import kotlinx.android.synthetic.main.ac2.*

class Ac2 : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ac2)
        button.setOnClickListener { view ->
            Log.d("ac2", "button")
            Thread.sleep(15 * 1000)
        }
        button2.setOnClickListener { view->
            Log.d("ac2", "button2")
            val i = Intent(this, Ac3::class.java)
            startActivity(i)
        }

        var v1 = intent.getIntExtra("k1", -1)
        var v2 = intent.getStringExtra("k2")
        Log.d("intent", v1.toString())
        Log.d("intent", v2)


    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return super.onTouchEvent(event)
    }


    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        Log.d("intent", "onSaveInstanceState")

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d("intent", "onRestoreInstanceState")

    }
}