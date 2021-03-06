package com.gervant08.finalqualifyingwork.ui.main.menu

import com.gervant08.finalqualifyingwork.R
import com.gervant08.finalqualifyingwork.model.data.dataclasses.MenuCategory
import com.gervant08.finalqualifyingwork.model.tools.JsonMenuParser
import com.gervant08.finalqualifyingwork.ui.main.menu.common.BaseFoodAdapter
import com.gervant08.finalqualifyingwork.ui.main.menu.common.BaseFoodFragment

class MenuFragment : BaseFoodFragment<MenuViewModel, MenuCategory>(R.layout.fragment_menu) {

    override fun getRecyclerId(): Int = R.id.rvBasketItems
    override fun getViewModel(): Class<MenuViewModel> = MenuViewModel::class.java

    override fun getJsonMenuParser(): JsonMenuParser =
        JsonMenuParser(requireContext())

    override fun initListInAdapter() {
        adapter.updateItemsList(viewModel.getMenuCategories())
    }

    override fun initAdapter() {
        adapter =  MenuAdapter(object : BaseFoodAdapter.OnItemClickListener<MenuCategory>{
            override fun onClickItem(data: MenuCategory) {
                viewModel.selectMenuCategory(data)
            }
        })
    }

}