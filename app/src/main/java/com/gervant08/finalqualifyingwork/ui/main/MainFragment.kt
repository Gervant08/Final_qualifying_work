package com.gervant08.finalqualifyingwork.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.gervant08.finalqualifyingwork.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainFragment : Fragment(R.layout.fragment_main) {
    private lateinit var mainBottomNavigationView: BottomNavigationView
    private val mainViewModel: MainViewModel by viewModels()
    companion object{
        const val ITEM_HOME = "Home"
        const val ITEM_BASKET = "Basket"
        const val ITEM_PROFILE = "Profile"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val navHostFragment = childFragmentManager.findFragmentById(R.id.main_screen_nav_host) as NavHostFragment
        mainBottomNavigationView = view.findViewById(R.id.main_bottom_navigation)
        setUpBottomNavigation(navHostFragment)
    }

    private fun setUpBottomNavigation(navHostFragment: NavHostFragment){
        with(mainBottomNavigationView){
            let {NavigationUI.setupWithNavController(it, navHostFragment.navController) }
            setOnNavigationItemSelectedListener { item ->
                when(item.title){
                    ITEM_HOME -> navHostFragment.navController.navigate(R.id.home_fragment)
                    ITEM_BASKET -> navHostFragment.navController.navigate(R.id.basket_fragment)
                    ITEM_PROFILE -> navHostFragment.navController.navigate(R.id.profile_fragment)
                }
                return@setOnNavigationItemSelectedListener true
            }
        }
    }
}