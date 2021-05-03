package com.gervant08.finalqualifyingwork.ui.main.menu.items

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gervant08.finalqualifyingwork.R
import com.gervant08.finalqualifyingwork.model.data.MenuItem

class ItemsAdapter: RecyclerView.Adapter<ItemsAdapter.ItemsViewHolder>() {

    private var menuItemsList = arrayListOf<MenuItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder =
        ItemsViewHolder(
            LayoutInflater.from(parent.context).inflate(1, parent, false))

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        holder.onBind(menuItemsList[position])
    }

    override fun getItemCount(): Int = menuItemsList.size

    fun initMenuItemsList(menuItemsList: ArrayList<MenuItem>){
        this.menuItemsList = menuItemsList
    }

    inner class ItemsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun onBind(menuItem: MenuItem){

        }

    }
}