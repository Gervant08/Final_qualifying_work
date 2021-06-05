package com.gervant08.finalqualifyingwork.ui.main.menu

import androidx.lifecycle.ViewModel
import com.gervant08.finalqualifyingwork.model.data.dataclasses.MenuCategory
import com.gervant08.finalqualifyingwork.model.data.objects.NavigationLiveData
import com.gervant08.finalqualifyingwork.model.tools.JsonMenuParser

class MenuViewModel(private val jsonMenuParser: JsonMenuParser) : ViewModel() {

    fun selectMenuCategory(menuCategory: MenuCategory) {
        NavigationLiveData.selectedCategoryLiveData.postValue(menuCategory)
    }

    fun getMenuCategories(): ArrayList<MenuCategory> =
        jsonMenuParser.getMenuCategoriesFromJson()

}