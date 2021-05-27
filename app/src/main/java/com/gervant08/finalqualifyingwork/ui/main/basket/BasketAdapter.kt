package com.gervant08.finalqualifyingwork.ui.main.basket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gervant08.finalqualifyingwork.R
import com.gervant08.finalqualifyingwork.model.data.BasketItem

class BasketAdapter(
    private val deleteListener: (basketItem: BasketItem) -> Unit,
    private val changeAmountListener: (dishesList: ArrayList<BasketItem>) -> Unit
) : RecyclerView.Adapter<BasketAdapter.BasketViewHolder>() {
    private var dishesList: ArrayList<BasketItem> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_basket, parent, false)
        return BasketViewHolder(view)
    }

    override fun onBindViewHolder(holder: BasketViewHolder, position: Int) {
        holder.onBind(dishesList[position])
    }

    override fun getItemCount(): Int = dishesList.size

    fun updateDishesList(dishesList: ArrayList<BasketItem>) {
        this.dishesList = dishesList
        notifyDataSetChanged()
    }

    fun getDishesList() = dishesList

    inner class BasketViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val basketItemImage: ImageView = itemView.findViewById(R.id.basketItemImage)
        private val basketItemTitle: TextView = itemView.findViewById(R.id.basketItemTitle)
        private val basketItemPrice: TextView = itemView.findViewById(R.id.basketItemPrice)
        private val basketItemCount: TextView = itemView.findViewById(R.id.basketItemCount)
        private val basketItemAmount: TextView = itemView.findViewById(R.id.basketItemAmountText)
        private val basketItemMinusButton: Button = itemView.findViewById(R.id.basketItemMinusButton)
        private val basketItemPlusButton: Button = itemView.findViewById(R.id.basketItemPlusButton)
        private val basketItemDeleteButton: ImageButton =
            itemView.findViewById(R.id.basketItemDeleteButton)

        fun plus(basketItem: BasketItem) {
            changeAmountListener(dishesList)
            basketItemCount.text = ("${basketItem.count}")
            basketItemPrice.text = ("${basketItem.price * basketItem.count} руб.")
        }

        fun minus(basketItem: BasketItem) {
            changeAmountListener(dishesList)

            if (basketItem.count == 0) {
                deleteListener(basketItem)
                return
            }

            basketItemCount.text = ("${basketItem.count}")
            basketItemPrice.text = ("${basketItem.price * basketItem.count} руб.")
        }

        fun onBind(basketItem: BasketItem) {
            basketItemImage.setImageResource(basketItem.imageResource)
            basketItemTitle.text = basketItem.title
            basketItemPrice.text = (basketItem.price * basketItem.count).toString()
            basketItemCount.text = basketItem.count.toString()
            basketItemMinusButton.setOnClickListener { basketItem.count -= 1; minus(basketItem) }
            basketItemPlusButton.setOnClickListener { basketItem.count += 1; plus(basketItem) }
            basketItemDeleteButton.setOnClickListener { deleteListener(basketItem) }
        }
    }

}