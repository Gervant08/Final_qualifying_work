package com.gervant08.finalqualifyingwork.ui.main.menu.items

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gervant08.finalqualifyingwork.R
import com.gervant08.finalqualifyingwork.model.data.MenuItem
import com.gervant08.finalqualifyingwork.ui.main.menu.common.listen

class ItemsAdapter(private val listener: (MenuItem) -> Unit): RecyclerView.Adapter<ItemsAdapter.ItemsViewHolder>() {

    private var menuItemsList = arrayListOf<MenuItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder{
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_menu_item, parent, false)
        return ItemsViewHolder(view).listen { pos ->
            listener(menuItemsList[pos])
        }
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        holder.onBind(menuItemsList[position])
    }

    override fun getItemCount(): Int = menuItemsList.size

    fun initMenuItemsList(menuItemsList: ArrayList<MenuItem>){
        this.menuItemsList = menuItemsList
    }

    inner class ItemsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val menuItemImage: ImageView = itemView.findViewById(R.id.menuItemImage)
        private val menuItemTitle: TextView = itemView.findViewById(R.id.menuItemTitle)
        private val menuItemPrice: TextView = itemView.findViewById(R.id.menuItemPrice)

        fun onBind(menuItem: MenuItem){
            menuItemImage.setImageResource(menuItem.imageResource)
            menuItemTitle.text = menuItem.title
            menuItemPrice.text = ("${menuItem.price}. ${menuItem.weight}")
        }

    }
}