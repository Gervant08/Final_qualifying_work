package com.gervant08.finalqualifyingwork.ui.main.menu.items

import androidx.lifecycle.ViewModel
import com.gervant08.finalqualifyingwork.model.data.dataclasses.MenuItem
import com.gervant08.finalqualifyingwork.model.data.objects.NavigationLiveData
import com.gervant08.finalqualifyingwork.model.tools.JsonMenuParser

class ItemsViewModel(private val jsonMenuParser: JsonMenuParser): ViewModel() {

    fun selectMenuItem(menuItem: MenuItem){
        NavigationLiveData.selectedMenuItemLiveData.postValue(menuItem)
    }

    fun getItemsListByCategory(categoryName: String): ArrayList<MenuItem> =
        jsonMenuParser.getMenuItemsFromJson(categoryName)
}