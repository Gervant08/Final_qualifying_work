package com.gervant08.finalqualifyingwork.model.tools

import android.content.Context
import com.gervant08.finalqualifyingwork.model.data.dataclasses.MenuCategory
import com.gervant08.finalqualifyingwork.model.data.dataclasses.MenuItem
import com.gervant08.finalqualifyingwork.model.data.objects.MenuLists
import org.json.JSONObject
import java.io.IOException

class JsonMenuParser(private val context: Context) {

    companion object {
        private const val FILE_NAME = "menu.json"
        private const val ITEM_TITLE = "title"
        private const val ITEM_DESCRIPTION = "description"
        private const val ITEM_PRICE = "price"
        private const val ITEM_WEIGHT = "weight"
    }

    fun getMenuCategoriesFromJson(): ArrayList<MenuCategory> {
        val menuCategoriesArray = arrayListOf<MenuCategory>()
        JSONObject(getJsonMenuFromAsset())
            .keys()
            .forEach {
                menuCategoriesArray.add(
                    MenuCategory(
                        it,
                        MenuLists.menuCategoriesImagesHashMap[it] ?: 0
                    )
                )
            }

        return menuCategoriesArray
    }

    fun getMenuItemsFromJson(categoryName: String): ArrayList<MenuItem> {
        val itemMenuList = arrayListOf<MenuItem>()
        val menuItemsArray = JSONObject(getJsonMenuFromAsset()).getJSONArray(categoryName)

        for (i in 0 until menuItemsArray.length()) {
            val jsonObject = menuItemsArray.getJSONObject(i)
            itemMenuList.add(
                MenuItem(
                    jsonObject.getString(ITEM_TITLE),
                    jsonObject.getString(ITEM_DESCRIPTION),
                    jsonObject.getInt(ITEM_PRICE),
                    jsonObject.getString(ITEM_WEIGHT),
                    MenuLists.menuItemsImagesHashMap[jsonObject.getString(ITEM_TITLE)] ?: 0
                )
            )
        }

        return itemMenuList
    }

    private fun getJsonMenuFromAsset(): String {
        val jsonString: String
        try {
            jsonString = context.assets.open(FILE_NAME).bufferedReader()
                .use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return ""
        }

        return jsonString
    }
}