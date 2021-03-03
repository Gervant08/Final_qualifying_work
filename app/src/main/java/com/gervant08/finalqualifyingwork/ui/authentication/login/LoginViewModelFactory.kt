package com.gervant08.finalqualifyingwork.ui.authentication.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gervant08.finalqualifyingwork.model.data.DataStoreManager

class LoginViewModelFactory(private val dataStoreManager: DataStoreManager) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
        LoginViewModel::class.java -> LoginViewModel(dataStoreManager)
        else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
    } as T
}