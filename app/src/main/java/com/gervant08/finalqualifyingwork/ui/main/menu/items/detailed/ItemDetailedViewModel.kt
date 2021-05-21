package com.gervant08.finalqualifyingwork.ui.main.menu.items.detailed

import androidx.lifecycle.ViewModel
import com.gervant08.finalqualifyingwork.model.data.BasketItem
import com.gervant08.finalqualifyingwork.model.data.MenuBasket
import com.gervant08.finalqualifyingwork.model.data.MenuItem
import com.gervant08.finalqualifyingwork.model.data.NavigateLiveData

class ItemDetailedViewModel: ViewModel() {

    fun addMenuItemInBasket(menuItem: MenuItem){
        NavigateLiveData.selectedMenuItemInBasketLiveData.value = BasketItem(
            menuItem.title,
            menuItem.price,
            menuItem.imageResource,
            1
        )
    }
}