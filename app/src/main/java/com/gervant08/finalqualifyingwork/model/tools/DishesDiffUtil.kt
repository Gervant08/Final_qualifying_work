package com.gervant08.finalqualifyingwork.model.tools

import androidx.recyclerview.widget.DiffUtil
import com.gervant08.finalqualifyingwork.model.data.dataclasses.BasketItem

class DishesDiffUtil(
    private val oldList: ArrayList<BasketItem>,
    private val newList: ArrayList<BasketItem>
): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].title == newList[newItemPosition].title
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when{
            oldList[oldItemPosition].title != newList[newItemPosition].title ->
                false
            oldList[oldItemPosition].imageResource != newList[newItemPosition].imageResource ->
                false
            oldList[oldItemPosition].price != newList[newItemPosition].price ->
                false
            else -> true
        }
    }
}