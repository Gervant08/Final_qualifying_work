package com.gervant08.finalqualifyingwork.ui.main.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gervant08.finalqualifyingwork.model.tools.JsonMenuParser
import com.gervant08.finalqualifyingwork.ui.authentication.AuthViewModel

class MenuViewModelFactory(private val jsonMenuParser: JsonMenuParser) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
        AuthViewModel::class.java -> MenuViewModel(jsonMenuParser)
        else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
    } as T
}