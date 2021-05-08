package com.gervant08.finalqualifyingwork.ui.authentication.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gervant08.finalqualifyingwork.model.tools.UserPreferences

class RegistrationViewModelFactory(private val dataStoreManager: UserPreferences) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
        RegistrationViewModel::class.java -> RegistrationViewModel(dataStoreManager)
        else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
    } as T
}