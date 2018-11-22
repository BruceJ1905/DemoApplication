package com.example.bruce.demoapplication.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.example.bruce.demoapplication.activity.Ac4
import com.example.bruce.demoapplication.aidl.IMyAidlInterface

class MyService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        Log.d("11", "onBind")
//        var msg = Message.obtain()
//        msg.data.putInt("k1", 1);
//        msg.data.putChar("k2", 'c')


        return MyBindle()
    }

    override fun onRebind(intent: Intent?) {
        Log.d("11", "onRebind")

        super.onRebind(intent)
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.d("11", "onUnbind")

        return super.onUnbind(intent)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("11", "onStartCommand " + Ac4.CNT)
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onCreate() {
        Log.d("11", "onCreate")

        super.onCreate()
    }

    override fun onDestroy() {
        Log.d("11", "onDestroy")

        super.onDestroy()
    }

    class MyBindle : IMyAidlInterface.Stub() {


        override fun foo() {
            Log.d("11", "my foo")
        }

        override fun fun1() : String? {
            return "my aidl"
        }


    }

}
