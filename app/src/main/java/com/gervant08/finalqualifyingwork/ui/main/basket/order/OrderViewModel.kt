package com.gervant08.finalqualifyingwork.ui.main.basket.order

import androidx.lifecycle.ViewModel
import com.gervant08.finalqualifyingwork.R
import com.gervant08.finalqualifyingwork.model.data.MenuBasket

class OrderViewModel : ViewModel() {
    companion object {
        const val ORDER_TABLE_0 = "Стол не выбран"
        const val ORDER_TABLE_1 = "Около выхода"
        const val ORDER_TABLE_2 = "Около окна"
        const val ORDER_TABLE_3 = "В центре зала"
        const val ORDER_TABLE_4 = "В конце зала"

        const val ORDER_HUMAN_COUNT_0 = "Количество человек: 0"
        const val ORDER_HUMAN_COUNT_1 = "Количество человек: 1"
        const val ORDER_HUMAN_COUNT_2 = "Количество человек: 2"
        const val ORDER_HUMAN_COUNT_3 = "Количество человек: 3"
        const val ORDER_HUMAN_COUNT_4 = "Количество человек: 4"
        const val ORDER_HUMAN_COUNT_5 = "Количество человек: 5"
        const val ORDER_HUMAN_COUNT_6 = "Количество человек: 6"
    }

    fun chooseTable(itemId: Int): String {
        return when (itemId) {
            R.id.basketOrderTableOption_1 -> ORDER_TABLE_1
            R.id.basketOrderTableOption_2 -> ORDER_TABLE_2
            R.id.basketOrderTableOption_3 -> ORDER_TABLE_3
            R.id.basketOrderTableOption_4 -> ORDER_TABLE_4
            else -> ORDER_TABLE_0
        }
    }

    fun chooseHumanCount(itemId: Int): String {
        return when (itemId) {
            R.id.basketOrderHumanCountMenuOption_1 -> ORDER_HUMAN_COUNT_1
            R.id.basketOrderHumanCountMenuOption_2 -> ORDER_HUMAN_COUNT_2
            R.id.basketOrderHumanCountMenuOption_3 -> ORDER_HUMAN_COUNT_3
            R.id.basketOrderHumanCountMenuOption_4 -> ORDER_HUMAN_COUNT_4
            R.id.basketOrderHumanCountMenuOption_5 -> ORDER_HUMAN_COUNT_5
            R.id.basketOrderHumanCountMenuOption_6 -> ORDER_HUMAN_COUNT_6
            else -> ORDER_HUMAN_COUNT_0
        }
    }

    fun calculateOrderAmount(): String {
        var amount = 0
        MenuBasket.dishesList.value!!.forEach {
           amount += it.price * it.count
        }
        return amount.toString()
    }
}