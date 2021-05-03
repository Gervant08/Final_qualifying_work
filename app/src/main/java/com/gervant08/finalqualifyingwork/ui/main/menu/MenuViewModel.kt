package com.gervant08.finalqualifyingwork.ui.main.menu

import androidx.lifecycle.ViewModel
import com.gervant08.finalqualifyingwork.model.data.MenuCategory
import com.gervant08.finalqualifyingwork.model.tools.JsonMenuParser

class MenuViewModel(private val jsonMenuParser: JsonMenuParser) : ViewModel() {
    private val menuCategoriesList = setMenuCategories()

    private fun setMenuCategories(): ArrayList<MenuCategory> =
        jsonMenuParser.getMenuCategoriesFromJson()

    fun getMenuCategories(): ArrayList<MenuCategory> = menuCategoriesList


}