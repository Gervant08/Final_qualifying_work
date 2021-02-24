package com.gervant08.finalqualifyingwork.ui.authentication.login

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gervant08.finalqualifyingwork.ui.authentication.AuthViewModel

class LoginViewModelFactory(private val application: Application) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
        AuthViewModel::class.java -> LoginViewModel(application)
        else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
    } as T
}