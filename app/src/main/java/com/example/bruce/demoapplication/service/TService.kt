package com.example.bruce.demoapplication.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class TService : Service() {
    override fun onBind(intent: Intent?): IBinder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    inner class TBinder : Binder() {

        fun getService() : TService {
            return this@TService;
        }
    }

}