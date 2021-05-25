package com.gervant08.finalqualifyingwork.ui.main.basket

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.gervant08.finalqualifyingwork.R
import androidx.recyclerview.widget.RecyclerView
import com.gervant08.finalqualifyingwork.model.data.MenuBasket
import com.gervant08.finalqualifyingwork.model.data.BasketItem
import com.gervant08.finalqualifyingwork.model.data.NavigateLiveData

class BasketFragment : Fragment(R.layout.fragment_basket) {
    private lateinit var basketRecyclerView: RecyclerView
    private val basketViewModel: BasketViewModel by viewModels()
    private lateinit var orderButton: Button
    private lateinit var orderAmountTextView: TextView
    private val basketAdapter =
        BasketAdapter({ basketItem ->  deleteItemFromBasket(basketItem)},
            { newDishesList ->  updateOrderAmount(newDishesList)})

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MenuBasket.dishesList.observe(this, this::onDishesInBasketChange)
        initBasketDishesList()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        basketRecyclerView = view.findViewById(R.id.rvBasketItems)
        basketRecyclerView.adapter = basketAdapter
        orderButton = view.findViewById(R.id.basketOrderButton)
        orderButton.setOnClickListener { goToOrderPage() }
        orderAmountTextView = view.findViewById(R.id.basketOrderAmount)
        orderAmountTextView.text = basketViewModel.calculatingOrderAmount(MenuBasket.dishesList.value!!).toString()
    }

    private fun initBasketDishesList() {
        basketAdapter.updateDishesList(MenuBasket.dishesList.value!!)
    }

    private fun goToOrderPage() {
        if (MenuBasket.dishesList.value!!.size > 0){
            NavigateLiveData.filledBasketLiveData.value = true
        }
    }

    private fun deleteItemFromBasket(basketItem: BasketItem){
        basketViewModel.deleteItemFromBasket(basketItem)
        orderAmountTextView.text = basketViewModel.calculatingOrderAmount(MenuBasket.dishesList.value!!).toString()
    }

    private fun onDishesInBasketChange(dishesList: ArrayList<BasketItem>) {
        basketAdapter.updateDishesList(dishesList)
    }

    private fun updateOrderAmount(basketItemsList: ArrayList<BasketItem>){
        MenuBasket.dishesList.value = basketItemsList
        orderAmountTextView.text = basketViewModel.calculatingOrderAmount(basketItemsList).toString()
    }


}