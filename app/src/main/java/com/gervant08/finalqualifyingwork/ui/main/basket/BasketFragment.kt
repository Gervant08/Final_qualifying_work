package com.gervant08.finalqualifyingwork.ui.main.basket

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.gervant08.finalqualifyingwork.R
import com.gervant08.finalqualifyingwork.model.data.MenuBasket
import com.gervant08.finalqualifyingwork.model.data.MenuItem
import com.gervant08.finalqualifyingwork.model.data.NavigateLiveData

class BasketFragment : Fragment(R.layout.fragment_basket) {
    private lateinit var basketRecyclerView: RecyclerView
    private val basketViewModel: BasketViewModel by viewModels()
    private val basketAdapter = BasketAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MenuBasket.dishesList.observe(this, this::onDishesInBasketChange)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun onDishesInBasketChange(dishesList: ArrayList<MenuItem>) {
        basketAdapter.updateDishesList(dishesList)
    }


}