package com.gervant08.finalqualifyingwork.ui.main.menu

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.gervant08.finalqualifyingwork.R
import com.gervant08.finalqualifyingwork.model.tools.JsonMenuParser
import com.gervant08.finalqualifyingwork.ui.main.menu.common.ViewModelFactory

class MenuFragment : Fragment(R.layout.fragment_menu) {
    private lateinit var menuRecyclerView: RecyclerView
    private val menuViewModel: MenuViewModel by viewModels {
        ViewModelFactory(
            JsonMenuParser.getInstance(
                requireContext()
            )
        )
    }
    private val menuAdapter =
        MenuAdapter { menuCategory -> menuViewModel.selectMenuCategory(menuCategory) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        menuRecyclerView = view.findViewById(R.id.rv_menu_categories)
        menuRecyclerView.adapter = menuAdapter
        initListInAdapter()
    }

    private fun initListInAdapter() {
        menuAdapter.initCategoriesList(menuViewModel.getMenuCategories())
    }

}