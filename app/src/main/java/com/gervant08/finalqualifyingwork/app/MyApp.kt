package com.gervant08.finalqualifyingwork.app

import android.app.Application
import android.content.Context

class MyApp : Application() {


    init { INSTANCE = this }

    companion object {
        lateinit var INSTANCE: MyApp
            private set

        val applicationContext: Context get() { return INSTANCE.applicationContext }
    }

//    init {
//        instance = this
//    }
//
//    companion object {
//        private var instance: MyApp? = null
//
//        fun applicationContext(): Context {
//            return instance!!.applicationContext
//        }
//    }
//
//    override fun onCreate() {
//        super.onCreate()
//        // initialize for any
//
//        // Use ApplicationContext.
//        // example: SharedPreferences etc...
//        val context: Context = MyApp.applicationContext()
//    }
}