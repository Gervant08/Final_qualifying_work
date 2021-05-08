package com.gervant08.finalqualifyingwork.ui.main.menu.items

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.gervant08.finalqualifyingwork.model.tools.JsonMenuParser
import com.gervant08.finalqualifyingwork.ui.main.menu.common.BaseFoodAdapter
import com.gervant08.finalqualifyingwork.ui.main.menu.common.BaseFoodFragment

class ItemsFragment(categoryName: String) : BaseFoodFragment<ItemsViewModel>(1) {

    override fun initListInAdapter() {

    }

    override fun getJsonMenuParser(): JsonMenuParser =
        JsonMenuParser.getInstance(requireContext())

}