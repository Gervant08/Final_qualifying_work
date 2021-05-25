package com.gervant08.finalqualifyingwork.ui.main.basket

import androidx.lifecycle.ViewModel
import com.gervant08.finalqualifyingwork.model.data.BasketItem
import com.gervant08.finalqualifyingwork.model.data.MenuBasket
import com.gervant08.finalqualifyingwork.model.data.NavigateLiveData

class BasketViewModel: ViewModel() {

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