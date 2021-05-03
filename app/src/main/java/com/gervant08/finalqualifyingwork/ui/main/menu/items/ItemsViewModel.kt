package com.gervant08.finalqualifyingwork.ui.main.menu.items

import androidx.lifecycle.ViewModel
import com.gervant08.finalqualifyingwork.model.data.MenuItem
import com.gervant08.finalqualifyingwork.model.tools.JsonMenuParser

class ItemsViewModel(private val jsonMenuParser: JsonMenuParser, categoryName: String): ViewModel() {
    private val itemsList = setItemsListByCategory(categoryName)

    private fun setItemsListByCategory(categoryName: String): ArrayList<MenuItem> =
        jsonMenuParser.getMenuItemsFromJson(categoryName)

    fun getItemsListByCategory(): ArrayList<MenuItem> = itemsList
}