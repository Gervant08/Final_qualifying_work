package com.gervant08.finalqualifyingwork.ui.main.menu.items

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gervant08.finalqualifyingwork.model.tools.JsonMenuParser
import com.gervant08.finalqualifyingwork.ui.authentication.AuthViewModel

class ItemsViewModelFactory (private val jsonMenuParser: JsonMenuParser, private val categoryName: String = "") : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
        AuthViewModel::class.java -> ItemsViewModel(jsonMenuParser, categoryName)
        else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
    } as T
}