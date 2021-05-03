package com.gervant08.finalqualifyingwork.ui.main.menu

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gervant08.finalqualifyingwork.model.data.MenuCategory
import com.gervant08.finalqualifyingwork.ui.main.menu.common.BaseFoodAdapter

class MenuAdapter: RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    private var categoriesList = arrayListOf<MenuCategory>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        TODO("Not yet implemented")
    }


    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    fun initCategoriesList(categoriesList: ArrayList<MenuCategory>){
        this.categoriesList = categoriesList
    }


    inner class MenuViewHolder(itemElement: View): RecyclerView.ViewHolder(itemElement){

    }
}