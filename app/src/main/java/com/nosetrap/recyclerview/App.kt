package com.nosetrap.recyclerview

import android.app.Application
import com.squareup.leakcanary.LeakCanary

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        //setup leak canary
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this)
        }
    }
}