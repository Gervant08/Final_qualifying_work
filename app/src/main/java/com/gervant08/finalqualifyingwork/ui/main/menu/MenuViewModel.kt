package com.gervant08.finalqualifyingwork.ui.main.menu

import androidx.lifecycle.ViewModel
import com.gervant08.finalqualifyingwork.model.data.MenuCategory
import com.gervant08.finalqualifyingwork.model.data.NavigateLiveData
import com.gervant08.finalqualifyingwork.model.tools.JsonMenuParser

class MenuViewModel(private val jsonMenuParser: JsonMenuParser) : ViewModel() {

    fun selectMenuCategory(menuCategory: MenuCategory) {
        NavigateLiveData.selectedCategoryLiveData.postValue(menuCategory)
    }

    fun getMenuCategories(): ArrayList<MenuCategory> =
        jsonMenuParser.getMenuCategoriesFromJson()

}