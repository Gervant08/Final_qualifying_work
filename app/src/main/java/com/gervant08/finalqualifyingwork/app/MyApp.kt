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

}