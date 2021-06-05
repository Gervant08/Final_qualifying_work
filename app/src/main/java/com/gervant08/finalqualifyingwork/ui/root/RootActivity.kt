package com.gervant08.finalqualifyingwork.ui.root

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.gervant08.finalqualifyingwork.R
import com.gervant08.finalqualifyingwork.model.data.objects.NavigationLiveData

class RootActivity : AppCompatActivity() {
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.app_nav_host) as NavHostFragment
        NavigationLiveData.loggedUserLiveData.observe(this, this::goToMainScreen)

    }

    private fun goToMainScreen(isLogged: Boolean) {
        if (isLogged)
            navHostFragment.navController.navigate(R.id.main_fragment)

    }
}