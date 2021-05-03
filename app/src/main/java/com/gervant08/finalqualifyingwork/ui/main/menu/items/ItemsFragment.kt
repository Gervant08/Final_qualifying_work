package com.gervant08.finalqualifyingwork.ui.main.menu.items

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.gervant08.finalqualifyingwork.model.tools.JsonMenuParser
import com.gervant08.finalqualifyingwork.ui.main.menu.common.BaseFoodFragment

class ItemsFragment(categoryName: String): BaseFoodFragment(1) {
    private val jsonMenuParser = JsonMenuParser.getInstance(requireContext())
    private val itemViewModel: ItemsViewModel by viewModels {ItemsViewModelFactory(jsonMenuParser, categoryName)}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

}