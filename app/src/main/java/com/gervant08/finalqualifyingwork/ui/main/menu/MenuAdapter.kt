package com.gervant08.finalqualifyingwork.ui.main.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gervant08.finalqualifyingwork.model.data.MenuCategory
import com.gervant08.finalqualifyingwork.ui.main.menu.common.BaseFoodAdapter

class MenuAdapter : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    private var categoriesList = arrayListOf<MenuCategory>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder =
        MenuViewHolder(
            LayoutInflater.from(parent.context).inflate(1, parent, false)
        )


    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.onBind(categoriesList[position])
    }

    override fun getItemCount(): Int = categoriesList.size

    fun initCategoriesList(categoriesList: ArrayList<MenuCategory>) {
        this.categoriesList = categoriesList
    }


    inner class MenuViewHolder(itemElement: View) : RecyclerView.ViewHolder(itemElement) {

        fun onBind(menuCategory: MenuCategory) {

        }
    }
}