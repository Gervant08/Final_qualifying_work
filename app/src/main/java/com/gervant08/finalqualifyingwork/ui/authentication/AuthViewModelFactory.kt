package com.gervant08.finalqualifyingwork.ui.authentication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AuthViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
        AuthViewModel::class.java -> AuthViewModel()
        else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
    } as T
}