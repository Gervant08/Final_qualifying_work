package com.gervant08.finalqualifyingwork.ui.main.menu.items.detailed

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.gervant08.finalqualifyingwork.R
import com.gervant08.finalqualifyingwork.model.data.objects.NavigationLiveData

class ItemDetailedFragment : Fragment(R.layout.fragment_menu_item_detailed) {
    private val viewModel: ItemDetailedViewModel by viewModels()
    private lateinit var imageView: ImageView
    private lateinit var titleTextView: TextView
    private lateinit var priceTextView: TextView
    private lateinit var weightTextView: TextView
    private lateinit var descriptionTextView: TextView
    private lateinit var addButton: Button
    private val selectedMenuItem = NavigationLiveData.selectedMenuItemLiveData.value!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageView = view.findViewById(R.id.itemDetailedImage)
        titleTextView = view.findViewById(R.id.itemDetailedTitle)
        priceTextView = view.findViewById(R.id.itemDetailedPrice)
        weightTextView = view.findViewById(R.id.itemDetailedWeight)
        descriptionTextView = view.findViewById(R.id.itemDetailedDescription)
        addButton = view.findViewById(R.id.basketOrderButton)

        initViews()
    }

    private fun initViews() {
        imageView.setImageResource(selectedMenuItem.imageResource)
        titleTextView.text = selectedMenuItem.title
        priceTextView.text = ("Цена: ${selectedMenuItem.price}" + " ₽")
        weightTextView.text = viewModel.weightOrVolume(selectedMenuItem.scalar)
        descriptionTextView.text = selectedMenuItem.description
        addButton.setOnClickListener { viewModel.addMenuItemInBasket(selectedMenuItem) }
    }
}