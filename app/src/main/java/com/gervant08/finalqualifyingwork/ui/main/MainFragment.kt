package com.gervant08.finalqualifyingwork.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.gervant08.finalqualifyingwork.R
import com.gervant08.finalqualifyingwork.model.data.dataclasses.BasketItem
import com.gervant08.finalqualifyingwork.model.data.dataclasses.MenuCategory
import com.gervant08.finalqualifyingwork.model.data.dataclasses.MenuItem
import com.gervant08.finalqualifyingwork.model.data.objects.NavigationLiveData
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainFragment : Fragment(R.layout.fragment_main) {
    private lateinit var bottomNavigationView: BottomNavigationView
    private val viewModel: MainViewModel by viewModels()
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var  itemMenu : String
    private lateinit var  itemBasket: String
    private lateinit var  itemProfile: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        NavigationLiveData.selectedCategoryLiveData.observe(
            this, this::onMenuCategorySelected
        )
        NavigationLiveData.selectedMenuItemLiveData.observe(
            this, this::onMenuItemSelected
        )

        NavigationLiveData.selectedMenuItemInBasketLiveData.observe(
            this, this::onMenuItemAddedInBasket
        )

        NavigationLiveData.filledBasketLiveData.observe(
            this, this::onBasketFilled)

        NavigationLiveData.madeOrderLiveData.observe(
            this, this::onOrderMade
        )

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navHostFragment =
            childFragmentManager.findFragmentById(R.id.main_screen_nav_host) as NavHostFragment
        bottomNavigationView = view.findViewById(R.id.main_bottom_navigation)
        itemMenu = getString(R.string.nav_menu_home)
        itemBasket = getString(R.string.nav_menu_basket)
        itemProfile = getString(R.string.nav_menu_profile)
        setUpBottomNavigation(navHostFragment)

    }

    private fun setUpBottomNavigation(navHostFragment: NavHostFragment) {
        with(bottomNavigationView) {
            let { NavigationUI.setupWithNavController(it, navHostFragment.navController) }
            setOnNavigationItemSelectedListener { item ->
                when (item.title) {
                    itemMenu -> navHostFragment.navController.navigate(R.id.menu_fragment)
                    itemBasket -> navHostFragment.navController.navigate(R.id.basket_fragment)
                    itemProfile -> navHostFragment.navController.navigate(R.id.profile_fragment)
                }
                return@setOnNavigationItemSelectedListener true
            }
        }
    }

    private fun onMenuCategorySelected(menuCategory: MenuCategory) {
        navHostFragment.navController.navigate(R.id.action_home_fragment_to_itemsFragment)
    }

    private fun onMenuItemSelected(menuItem: MenuItem) {
        navHostFragment.navController.navigate(R.id.action_itemsFragment_to_itemDetailedFragment)
    }

    private fun onMenuItemAddedInBasket(basketItem: BasketItem) {
        navHostFragment.navController.navigate(R.id.action_itemDetailedFragment_to_basket_fragment)
    }

    private fun onBasketFilled(isFilled: Boolean) {
        navHostFragment.navController.navigate(R.id.action_basket_fragment_to_orderFragment)
    }

    private fun onOrderMade(isMade: Boolean) {
    }

}