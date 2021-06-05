package com.gervant08.finalqualifyingwork.model.data.objects

import androidx.lifecycle.MutableLiveData
import com.gervant08.finalqualifyingwork.model.data.dataclasses.BasketItem
import com.gervant08.finalqualifyingwork.model.data.dataclasses.MenuCategory
import com.gervant08.finalqualifyingwork.model.data.dataclasses.MenuItem

object NavigationLiveData {
    val loggedUserLiveData = MutableLiveData<Boolean>()
    val selectedCategoryLiveData = MutableLiveData<MenuCategory>()
    val selectedMenuItemLiveData = MutableLiveData<MenuItem>()
    val selectedMenuItemInBasketLiveData = MutableLiveData<BasketItem>()
    val filledBasketLiveData = MutableLiveData<Boolean>()
    val madeOrderLiveData  = MutableLiveData<Boolean>()

}