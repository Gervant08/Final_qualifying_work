package com.gervant08.finalqualifyingwork.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.gervant08.finalqualifyingwork.R
import com.gervant08.finalqualifyingwork.model.data.BasketItem
import com.gervant08.finalqualifyingwork.model.data.MenuCategory
import com.gervant08.finalqualifyingwork.model.data.MenuItem
import com.gervant08.finalqualifyingwork.model.data.NavigateLiveData
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainFragment : Fragment(R.layout.fragment_main) {
    private lateinit var bottomNavigationView: BottomNavigationView
    private val viewModel: MainViewModel by viewModels()
    private lateinit var navHostFragment: NavHostFragment

    companion object {
        const val ITEM_HOME = "Меню"
        const val ITEM_BASKET = "Корзина"
        const val ITEM_PROFILE = "Профиль"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        NavigateLiveData.selectedCategoryLiveData.observe(
            this, this::onMenuCategorySelected
        )
        NavigateLiveData.selectedMenuItemLiveData.observe(
            this, this::onMenuItemSelected
        )

        NavigateLiveData.selectedMenuItemInBasketLiveData.observe(
            this, this::onMenuItemAddedInBasket
        )

        NavigateLiveData.filledBasketLiveData.observe(
            this, this::onBasketFilled)

        NavigateLiveData.madeOrderLiveData.observe(
            this, this::onOrderMade
        )

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navHostFragment =
            childFragmentManager.findFragmentById(R.id.main_screen_nav_host) as NavHostFragment
        bottomNavigationView = view.findViewById(R.id.main_bottom_navigation)
        setUpBottomNavigation(navHostFragment)
    }

    private fun setUpBottomNavigation(navHostFragment: NavHostFragment) {
        with(bottomNavigationView) {
            let { NavigationUI.setupWithNavController(it, navHostFragment.navController) }
            setOnNavigationItemSelectedListener { item ->
                when (item.title) {
                    ITEM_HOME -> navHostFragment.navController.navigate(R.id.menu_fragment)
                    ITEM_BASKET -> navHostFragment.navController.navigate(R.id.basket_fragment)
                    ITEM_PROFILE -> navHostFragment.navController.navigate(R.id.profile_fragment)
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