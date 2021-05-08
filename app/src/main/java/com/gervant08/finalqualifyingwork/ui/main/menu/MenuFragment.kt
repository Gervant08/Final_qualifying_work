package com.gervant08.finalqualifyingwork.ui.main.menu

import androidx.recyclerview.widget.RecyclerView
import com.gervant08.finalqualifyingwork.R
import com.gervant08.finalqualifyingwork.model.tools.JsonMenuParser
import com.gervant08.finalqualifyingwork.ui.main.menu.common.BaseFoodFragment

class MenuFragment : BaseFoodFragment<MenuViewModel>(R.layout.fragment_home) {

    private lateinit var menuRecyclerView: RecyclerView


    override fun initListInAdapter() {
        menuAdapter.initCategoriesList(viewModel.setMenuCategories())
    }

    override fun getJsonMenuParser(): JsonMenuParser =
        JsonMenuParser.getInstance(requireContext())

    override fun getViewModel() = MenuViewModel::class.java


}