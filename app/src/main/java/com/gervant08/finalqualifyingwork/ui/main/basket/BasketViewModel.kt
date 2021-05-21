package com.gervant08.finalqualifyingwork.ui.main.basket

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gervant08.finalqualifyingwork.model.data.BasketItem
import com.gervant08.finalqualifyingwork.model.data.MenuBasket
import com.gervant08.finalqualifyingwork.model.data.MenuItem

class BasketViewModel: ViewModel() {
    var dishesList: ArrayList<BasketItem> = arrayListOf()

    fun initBasketDishesList(menuItem: BasketItem) {
        val newMenuItemsList = MenuBasket.dishesList.apply {
            this.value!!.add(menuItem)
        }
        MenuBasket.dishesList.value = newMenuItemsList.value
    }

    fun convertMenuItemsToBasketItems(menuItemsList: ArrayList<MenuItem>): ArrayList<BasketItem>{
        val basketItemsList = arrayListOf<BasketItem>()
        menuItemsList.forEach {
            basketItemsList.add(
                BasketItem(
                title = it.title,
                price = it.price,
                imageResource = it.imageResource,
                count = 1
            )
            )
        }

        return basketItemsList
    }

    fun calculatingOrderAmount(basketItemsList: ArrayList<BasketItem>): Int{
        var orderAmount = 0
        basketItemsList.forEach { basketItem ->
            orderAmount += (basketItem.price * basketItem.count)
        }

        return orderAmount
    }


    fun deleteItemFromBasket(basketItem: BasketItem){
        val newMenuItemsList = MenuBasket.dishesList.apply {
            this.value!!.remove(basketItem)
        }
        MenuBasket.dishesList.value = newMenuItemsList.value
    }
}