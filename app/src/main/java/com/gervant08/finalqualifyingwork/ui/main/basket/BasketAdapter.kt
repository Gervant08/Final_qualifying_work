package com.gervant08.finalqualifyingwork.ui.main.basket

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gervant08.finalqualifyingwork.model.data.MenuItem

class BasketAdapter: RecyclerView.Adapter<BasketAdapter.BasketViewHolder>() {
    private var dishesList: ArrayList<MenuItem> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: BasketViewHolder, position: Int) {
       holder.onBind()
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    fun updateDishesList(dishesList: ArrayList<MenuItem>){
        this.dishesList = dishesList
        notifyDataSetChanged()
    }

    inner class BasketViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun onBind(){

        }
    }

}