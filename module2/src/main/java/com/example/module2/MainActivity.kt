package com.example.module2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*
import org.simple.eventbus.EventBus
import org.simple.eventbus.Subscriber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        EventBus.getDefault().register(this)

        Toast.makeText(this, "ac2", Toast.LENGTH_SHORT).show()

        module2_button.setOnClickListener { _->
//            EventBus.getDefault().post(MessageEvent("msg1"))
            EventBus.getDefault().post("hello i'm m2", "m2")

        }


    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

    @Subscriber(tag = "m3")
    fun onModule3Msg(msg : String) {
        Log.d("11", "onMsg m3 = $msg")
    }
}
