package com.gervant08.finalqualifyingwork.ui.main.menu.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gervant08.finalqualifyingwork.R
import com.gervant08.finalqualifyingwork.model.data.MenuCategory
import com.gervant08.finalqualifyingwork.model.data.MenuItem


abstract class BaseFoodAdapter<T : Any>(val listener: OnItemClickListener<T>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var itemList = arrayListOf<T>()
    private var itemClickListener: OnItemClickListener<T>? = null

    init {
        itemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return getViewHolder(
            LayoutInflater.from(parent.context).inflate(viewType, parent, false),
            viewType
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as Binder<T>).onBind(itemList[position], listener)
    }

    override fun getItemCount(): Int = itemList.size

    override fun getItemViewType(position: Int): Int = getLayoutId(position, itemList[position])

    fun updateItemsList(itemList: ArrayList<T>) {
        this.itemList = itemList
        notifyDataSetChanged()
    }

    protected abstract fun getLayoutId(position: Int, obj: T): Int


    protected open fun getViewHolder(view: View, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolderFactory.create(view, viewType)
    }

    internal interface Binder<T> {
        fun onBind(data: T, listener: OnItemClickListener<T>?)
    }

    interface OnItemClickListener<T> {
        fun onClickItem(data: T)
    }

    object ViewHolderFactory {
        fun create(view: View, viewType: Int): RecyclerView.ViewHolder {
            return when (viewType) {
                R.layout.item_menu_category -> MenuCategoryViewHolder(view)
                R.layout.item_menu_item -> MenuItemViewHolder(view)
                else -> throw Exception("Wrong view type")
            }
        }

        class MenuCategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
            Binder<MenuCategory> {
            private val categoryImage: ImageView = itemView.findViewById(R.id.category_image)
            private val categoryTitle: TextView = itemView.findViewById(R.id.category_title)

            override fun onBind(data: MenuCategory, listener: OnItemClickListener<MenuCategory>?) {
                categoryTitle.text = data.title
                categoryImage.setImageResource(data.imageResource)
                itemView.setOnClickListener { listener?.onClickItem(data) }
            }
        }

        class MenuItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
            Binder<MenuItem> {
            private val menuItemImage: ImageView = itemView.findViewById(R.id.menuItemImage)
            private val menuItemTitle: TextView = itemView.findViewById(R.id.menuItemTitle)
            private val menuItemPrice: TextView = itemView.findViewById(R.id.menuItemPrice)

            private fun weightOrVolume(scalar: String): String {
                return if (scalar.contains("гр", true))
                    "Вес: $scalar"
                else
                    "Объем: $scalar"
            }

            override fun onBind(data: MenuItem, listener: OnItemClickListener<MenuItem>?) {
                menuItemImage.setImageResource(data.imageResource)
                menuItemTitle.text = data.title
                menuItemPrice.text = ("Цена: ${data.price} ₽ ${weightOrVolume(data.scalar)}")
                itemView.setOnClickListener { listener?.onClickItem(data) }
            }
        }
    }

}

