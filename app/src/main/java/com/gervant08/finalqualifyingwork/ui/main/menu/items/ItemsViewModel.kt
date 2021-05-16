package com.gervant08.finalqualifyingwork.ui.main.menu.items

import androidx.lifecycle.ViewModel
import com.gervant08.finalqualifyingwork.model.data.MenuItem
import com.gervant08.finalqualifyingwork.model.data.NavigateLiveData
import com.gervant08.finalqualifyingwork.model.tools.JsonMenuParser

class ItemsViewModel(private val jsonMenuParser: JsonMenuParser): ViewModel() {

    fun selectMenuItem(menuItem: MenuItem){
        NavigateLiveData.selectedMenuItemLiveData.postValue(menuItem)
    }

    fun getItemsListByCategory(categoryName: String): ArrayList<MenuItem> =
        jsonMenuParser.getMenuItemsFromJson(categoryName)
}