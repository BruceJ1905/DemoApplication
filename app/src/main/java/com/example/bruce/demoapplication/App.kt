package com.example.bruce.demoapplication

import android.annotation.TargetApi
import android.app.Application
import android.os.Build

class App : Application() {

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    override fun onCreate() {
//        super.onCreate()
//        Log.d("11", "app oncreate")
//
//        var info = packageManager.getApplicationInfo(packageName, PackageManager.GET_META_DATA)
//        var channel = info.metaData.getString("UMENG_CHANNEL", "default")
//
//        Log.d("11", channel)


    }

}