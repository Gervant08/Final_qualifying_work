package com.gervant08.finalqualifyingwork.model.data.objects

import androidx.lifecycle.MutableLiveData
import com.gervant08.finalqualifyingwork.model.data.dataclasses.BasketItem

object MenuBasket {
    val dishesList = MutableLiveData<ArrayList<BasketItem>>(arrayListOf())
}