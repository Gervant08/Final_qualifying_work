package com.gervant08.finalqualifyingwork.ui.main.menu.items.detailed

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.gervant08.finalqualifyingwork.R
import com.gervant08.finalqualifyingwork.model.data.NavigateLiveData

class ItemDetailedFragment : Fragment(R.layout.fragment_menu_item_detailed) {
    private val viewModel: ItemDetailedViewModel by viewModels()
    private lateinit var itemImageView: ImageView
    private lateinit var itemTitleTextView: TextView
    private lateinit var itemPriceTextView: TextView
    private lateinit var itemWeightTextView: TextView
    private lateinit var itemDescriptionTextView: TextView
    private lateinit var itemAddButton: Button
    private val selectedMenuItem = NavigateLiveData.selectedMenuItemLiveData.value!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemImageView = view.findViewById(R.id.itemDetailedImage)
        itemTitleTextView = view.findViewById(R.id.itemDetailedTitle)
        itemPriceTextView = view.findViewById(R.id.itemDetailedPrice)
        itemWeightTextView = view.findViewById(R.id.itemDetailedWeight)
        itemDescriptionTextView = view.findViewById(R.id.itemDetailedDescription)
        itemAddButton = view.findViewById(R.id.basketOrderButton)

        initViews()
    }

    private fun weightOrVolume(scalar: String): String{
        return if (scalar.contains("гр", true))
            "Вес: $scalar"
        else
            "Объем: $scalar"
    }

    private fun initViews() {
        itemImageView.setImageResource(selectedMenuItem.imageResource)
        itemTitleTextView.text = selectedMenuItem.title
        itemPriceTextView.text = ("Цена: ${selectedMenuItem.price}")
        itemWeightTextView.text = weightOrVolume(selectedMenuItem.scalar)
        itemDescriptionTextView.text = selectedMenuItem.description
        itemAddButton.setOnClickListener { viewModel.addMenuItemInBasket(selectedMenuItem) }
    }
}