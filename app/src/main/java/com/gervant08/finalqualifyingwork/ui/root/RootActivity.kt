package com.gervant08.finalqualifyingwork.ui.root

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gervant08.finalqualifyingwork.R
import com.gervant08.finalqualifyingwork.app.MyApp
import com.gervant08.finalqualifyingwork.model.data.DataStoreManager
import com.gervant08.finalqualifyingwork.ui.authentication.AuthFragment

class RootActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dataStoreManager = DataStoreManager(MyApp.applicationContext)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, AuthFragment(dataStoreManager))
            .commit()

    }
}