package com.gervant08.finalqualifyingwork.ui.main.menu.items.detailed

import androidx.lifecycle.ViewModel
import com.gervant08.finalqualifyingwork.model.data.dataclasses.BasketItem
import com.gervant08.finalqualifyingwork.model.data.objects.MenuBasket
import com.gervant08.finalqualifyingwork.model.data.dataclasses.MenuItem
import com.gervant08.finalqualifyingwork.model.data.objects.NavigationLiveData

class ItemDetailedViewModel: ViewModel() {

    fun addMenuItemInBasket(menuItem: MenuItem){
        val basketItem = BasketItem(
            menuItem.title,
            menuItem.price,
            menuItem.imageResource,
            1
        )
        if (MenuBasket.dishesList.value == null)
            MenuBasket.dishesList.value = arrayListOf(basketItem)
        else{
            val newList = arrayListOf<BasketItem>()
            with(newList){
                addAll(MenuBasket.dishesList.value!!)
                add(basketItem)
            }
            MenuBasket.dishesList.value = newList
        }

        NavigationLiveData.selectedMenuItemInBasketLiveData.value = basketItem
    }

    fun weightOrVolume(scalar: String): String{
        return if (scalar.contains("гр", true))
            " Вес: $scalar"
        else
            " Объем: $scalar"
    }
}