package com.gervant08.finalqualifyingwork.ui.root

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.gervant08.finalqualifyingwork.R
import com.gervant08.finalqualifyingwork.app.MyApp
import com.gervant08.finalqualifyingwork.model.data.DataStoreManager
import com.gervant08.finalqualifyingwork.ui.authentication.AuthFragment
import com.gervant08.finalqualifyingwork.ui.main.fragments.BasketFragment
import com.gervant08.finalqualifyingwork.ui.main.fragments.HomeFragment
import com.gervant08.finalqualifyingwork.ui.main.fragments.ProfileFragment

class RootActivity : AppCompatActivity() {
    private val dataStoreManager = DataStoreManager(MyApp.applicationContext)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dataStoreManager = DataStoreManager(MyApp.applicationContext)
        val transaction = supportFragmentManager.beginTransaction()
                .replace(R.id.container, AuthFragment(dataStoreManager)).commit()


    }
}