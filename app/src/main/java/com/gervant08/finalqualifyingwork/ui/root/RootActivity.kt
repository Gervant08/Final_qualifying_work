package com.gervant08.finalqualifyingwork.ui.root

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import com.gervant08.finalqualifyingwork.R
import com.gervant08.finalqualifyingwork.app.MyApp
import com.gervant08.finalqualifyingwork.model.data.DataStoreManager
import com.gervant08.finalqualifyingwork.model.data.User
import com.gervant08.finalqualifyingwork.model.data.UserLiveData

class RootActivity : AppCompatActivity() {
    private lateinit var navHostFragment: NavHostFragment
    private val dataStoreManager = DataStoreManager(MyApp.applicationContext)
    private lateinit var  bundle: Bundle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.app_nav_host) as NavHostFragment
        bundle = bundleOf("dataStoreManager" to 33)
        UserLiveData.loggedUserLiveData.observe(this, this::goToMainScreen)

        navigateTo(R.id.auth_fragment, bundle)
    }

    private fun goToMainScreen(user: User){
        navigateTo(R.id.main_fragment)
    }

    private fun navigateTo(fragmentId: Int, bundle: Bundle? = null){
        if (bundle != null){
            navHostFragment.navController.navigate(fragmentId, bundle)
        }
        navHostFragment.navController.navigate(fragmentId)
    }
}