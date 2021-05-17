package com.gervant08.finalqualifyingwork.ui.main.menu.items.detailed

import androidx.lifecycle.ViewModel
import com.gervant08.finalqualifyingwork.model.data.MenuBasket
import com.gervant08.finalqualifyingwork.model.data.MenuItem
import com.gervant08.finalqualifyingwork.model.data.NavigateLiveData

class ItemDetailedViewModel: ViewModel() {

    fun addMenuItemInBasket(menuItem: MenuItem){
        val newMenuItemsList = MenuBasket.dishesList.apply {
            this.value!!.add(menuItem)
        }

        MenuBasket.dishesList.value = newMenuItemsList.value
        NavigateLiveData.selectedMenuItemInBasketLiveData.postValue(menuItem)
    }
}