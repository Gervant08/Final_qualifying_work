package com.gervant08.finalqualifyingwork.ui.main.menu.items

import com.gervant08.finalqualifyingwork.R
import com.gervant08.finalqualifyingwork.model.data.MenuItem
import com.gervant08.finalqualifyingwork.model.data.NavigateLiveData
import com.gervant08.finalqualifyingwork.model.tools.JsonMenuParser
import com.gervant08.finalqualifyingwork.ui.main.menu.common.BaseFoodAdapter
import com.gervant08.finalqualifyingwork.ui.main.menu.common.BaseFoodFragment

class ItemsFragment : BaseFoodFragment<ItemsViewModel, MenuItem>(R.layout.fragment_menu_items) {

    override fun getRecyclerId(): Int = R.id.rv_menu_items
    override fun getViewModel(): Class<ItemsViewModel> = ItemsViewModel::class.java

    override fun getJsonMenuParser(): JsonMenuParser =
        JsonMenuParser(requireContext())

    override fun initListInAdapter() {
        adapter.updateItemsList(viewModel.getItemsListByCategory(NavigateLiveData.selectedCategoryLiveData.value!!.title))
    }

    override fun initAdapter() {
        adapter = ItemsAdapter(object : BaseFoodAdapter.OnItemClickListener<MenuItem> {
            override fun onClickItem(data: MenuItem) {
                viewModel.selectMenuItem(data)
            }
        })
    }


}