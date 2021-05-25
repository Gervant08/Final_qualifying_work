package com.gervant08.finalqualifyingwork.model.data

import androidx.lifecycle.MutableLiveData

object NavigateLiveData {
    val loggedUserLiveData = MutableLiveData<Boolean>()
    val selectedCategoryLiveData = MutableLiveData<MenuCategory>()
    val selectedMenuItemLiveData = MutableLiveData<MenuItem>()
    val selectedMenuItemInBasketLiveData = MutableLiveData<BasketItem>()
    val filledBasketLiveData = MutableLiveData<Boolean>()
    val madeOrderLiveData  = MutableLiveData<Boolean>()

}