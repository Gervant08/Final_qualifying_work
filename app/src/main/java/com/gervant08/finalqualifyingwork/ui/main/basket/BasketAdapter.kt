package com.gervant08.finalqualifyingwork.ui.main.basket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gervant08.finalqualifyingwork.R
import com.gervant08.finalqualifyingwork.model.data.BasketItem

class BasketAdapter(private val listener: (basketItem: BasketItem) -> Unit): RecyclerView.Adapter<BasketAdapter.BasketViewHolder>() {
    private var dishesList: ArrayList<BasketItem> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_basket, parent, false)
        return BasketViewHolder(view)
    }

    override fun onBindViewHolder(holder: BasketViewHolder, position: Int) {
       holder.onBind(dishesList[position])
    }

    override fun getItemCount(): Int = dishesList.size

    fun updateDishesList(dishesList: ArrayList<BasketItem>){
        this.dishesList = dishesList
        notifyDataSetChanged()
    }

    fun calculatingOrderAmount(basketItemsList: ArrayList<BasketItem>): Int{
        var orderAmount = 0
        basketItemsList.forEach { basketItem ->
            orderAmount += (basketItem.price * basketItem.count)
        }

        return orderAmount
    }


    inner class BasketViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val basketItemImage: ImageView = itemView.findViewById(R.id.basketItemImage)
        private val basketItemTitle: TextView = itemView.findViewById(R.id.basketItemTitle)
        private val basketItemPrice: TextView = itemView.findViewById(R.id.basketItemPrice)
        private val basketItemCount: TextView = itemView.findViewById(R.id.basketItemCount)
        private val basketItemAmount: TextView = itemView.findViewById(R.id.basketItemAmount)
        private val basketItemMinusButton: Button = itemView.findViewById(R.id.basketItemMinusButton)
        private val basketItemPlusButton: Button = itemView.findViewById(R.id.basketItemPlusButton)
        private val basketItemDeleteButton: Button = itemView.findViewById(R.id.basketItemDeleteButton)

        fun plus(basketItem: BasketItem){
            val dishesCount = basketItem.count + 1
            basketItemCount.text = ("$dishesCount")
            basketItemPrice.text = ("${basketItem.price * dishesCount} руб.")
        }

        fun minus(basketItem: BasketItem){
            val dishesCount = basketItem.count - 1
            if (dishesCount == 0) {
                listener(basketItem)
                return
            }

            basketItemCount.text = ("$dishesCount")
            basketItemPrice.text = ("${basketItem.price * dishesCount} руб.")
        }

        fun onBind(basketItem: BasketItem) {
            basketItemImage.setImageResource(basketItem.imageResource)
            basketItemTitle.text = basketItem.title
            basketItemPrice.text = basketItem.price.toString()
            basketItemMinusButton.setOnClickListener { minus(basketItem) }
            basketItemPlusButton.setOnClickListener { plus(basketItem) }
            basketItemDeleteButton.setOnClickListener { listener(basketItem) }
        }
    }

}