package com.gervant08.finalqualifyingwork.ui.authentication.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gervant08.finalqualifyingwork.model.data.User
import com.gervant08.finalqualifyingwork.model.tools.UserPreferences
import com.gervant08.finalqualifyingwork.model.data.UserLiveData
import kotlinx.coroutines.launch

class RegistrationViewModel(private val dataStoreManager: UserPreferences) : ViewModel() {

    fun registration(email: String, password: String) {
        viewModelScope.launch {
            dataStoreManager.writeData(email, password)
            UserLiveData.loggedUserLiveData.postValue(User(email, password))
        }

    }
}