package com.gervant08.finalqualifyingwork.ui.main.basket

import androidx.lifecycle.ViewModel
import com.gervant08.finalqualifyingwork.model.data.MenuBasket
import com.gervant08.finalqualifyingwork.model.data.MenuItem

class BasketViewModel: ViewModel() {

    fun initBasketDishesList(menuItem: MenuItem) {
        val newMenuItemsList = MenuBasket.dishesList.apply {
            this.value!!.add(menuItem)
        }
        MenuBasket.dishesList.value = newMenuItemsList.value
    }
}