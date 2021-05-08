package com.gervant08.finalqualifyingwork.ui.main.menu.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gervant08.finalqualifyingwork.model.tools.JsonMenuParser
import com.gervant08.finalqualifyingwork.ui.main.menu.MenuViewModel
import com.gervant08.finalqualifyingwork.ui.main.menu.items.ItemsViewModel

class ViewModelFactory(
    private val jsonMenuParser: JsonMenuParser
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
        MenuViewModel::class.java -> MenuViewModel(jsonMenuParser)
        ItemsViewModel::class.java -> ItemsViewModel(jsonMenuParser)
        else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
    } as T
}