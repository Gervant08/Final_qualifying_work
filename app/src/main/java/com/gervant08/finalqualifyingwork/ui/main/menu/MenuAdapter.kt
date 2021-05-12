package com.gervant08.finalqualifyingwork.ui.main.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gervant08.finalqualifyingwork.R
import com.gervant08.finalqualifyingwork.model.data.MenuCategory
import com.gervant08.finalqualifyingwork.model.data.NavigateLiveData
import com.gervant08.finalqualifyingwork.ui.main.menu.common.listen

class MenuAdapter() : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    private var categoriesList = arrayListOf<MenuCategory>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_menu_category, parent, false)
        return MenuViewHolder(view).listen { pos ->
            NavigateLiveData.selectedCategoryLiveData
                .postValue(categoriesList[pos])
        }
    }


    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.onBind(categoriesList[position])
    }

    override fun getItemCount(): Int = categoriesList.size

    fun initCategoriesList(categoriesList: ArrayList<MenuCategory>) {
        this.categoriesList = categoriesList
    }

    inner class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val categoryImage: ImageView = itemView.findViewById(R.id.category_image)
        private val categoryTitle: TextView = itemView.findViewById(R.id.category_title)

        fun onBind(menuCategory: MenuCategory) {
            categoryTitle.text = menuCategory.title
            categoryImage.setImageResource(menuCategory.imageResource)
        }
    }
}