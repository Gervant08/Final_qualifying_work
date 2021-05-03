package com.gervant08.finalqualifyingwork.ui.main.menu

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.gervant08.finalqualifyingwork.R
import com.gervant08.finalqualifyingwork.ui.main.MainViewModel
import com.gervant08.finalqualifyingwork.ui.main.menu.common.BaseFoodAdapter
import com.gervant08.finalqualifyingwork.ui.main.menu.common.BaseFoodFragment

class MenuFragment : BaseFoodFragment(R.layout.fragment_home) {

    private val menuAdapter = MenuAdapter()
    private lateinit var menuRecyclerView: RecyclerView
    override val viewModel: MenuViewModel by viewModels()
    override lateinit var recyclerView: RecyclerView
    override val adapter: BaseFoodAdapter = MenuAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    private fun initCategoriesListInAdapter(){
        menuAdapter.initCategoriesList(viewModel.getMenuCategories())
    }

}