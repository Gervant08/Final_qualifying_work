package com.gervant08.finalqualifyingwork.model.data

import androidx.lifecycle.MediatorLiveData

object CurrentOrder {
    val order = MediatorLiveData<Order>()
}