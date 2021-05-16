package com.gervant08.finalqualifyingwork.ui.main.menu.items

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.gervant08.finalqualifyingwork.R
import com.gervant08.finalqualifyingwork.model.data.NavigateLiveData
import com.gervant08.finalqualifyingwork.model.tools.JsonMenuParser
import com.gervant08.finalqualifyingwork.ui.main.menu.common.ViewModelFactory

class ItemsFragment : Fragment(R.layout.fragment_menu_items) {
    private lateinit var itemsRecyclerView: RecyclerView
    private val itemsViewModel: ItemsViewModel by viewModels {
        ViewModelFactory(
            JsonMenuParser.getInstance(
                requireContext()
            )
        )
    }
    private val itemsAdapter =
        ItemsAdapter { menuItem -> itemsViewModel.selectMenuItem(menuItem) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemsRecyclerView = view.findViewById(R.id.rv_menu_items)
        itemsRecyclerView.adapter = itemsAdapter
        initListInAdapter()
    }

    private fun initListInAdapter() {
        itemsAdapter.initMenuItemsList(itemsViewModel.getItemsListByCategory(NavigateLiveData.selectedCategoryLiveData.value!!.title))
    }


}