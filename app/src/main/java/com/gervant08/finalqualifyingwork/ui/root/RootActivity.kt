package com.gervant08.finalqualifyingwork.ui.root

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.gervant08.finalqualifyingwork.R
import com.gervant08.finalqualifyingwork.app.MyApp
import com.gervant08.finalqualifyingwork.model.data.*
import com.gervant08.finalqualifyingwork.model.tools.JsonMenuParser

class RootActivity : AppCompatActivity() {
    private lateinit var navHostFragment: NavHostFragment
    private val jsonMenuParser = JsonMenuParser.getInstance(MyApp.applicationContext)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.app_nav_host) as NavHostFragment
        NavigateLiveData.loggedUserLiveData.observe(this, this::goToMainScreen)

    }

    private fun goToMainScreen(isLogged: Boolean) {
        if (isLogged)
            navigateTo(R.id.main_fragment)

    }

    private fun navigateTo(fragmentId: Int) {
        navHostFragment.navController.navigate(fragmentId)
    }


}