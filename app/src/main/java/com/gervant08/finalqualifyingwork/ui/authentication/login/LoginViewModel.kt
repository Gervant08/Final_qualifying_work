package com.gervant08.finalqualifyingwork.ui.authentication.login

import androidx.lifecycle.ViewModel
import com.gervant08.finalqualifyingwork.model.data.User
import com.gervant08.finalqualifyingwork.model.tools.UserPreferences
import com.gervant08.finalqualifyingwork.model.data.NavigateLiveData

class LoginViewModel(
    private val dataStoreManager: UserPreferences
) : ViewModel() {


    fun login(userEmail: String, userPassword: String) {
        if (userEmail == dataStoreManager.userEmail.toString() && userPassword == dataStoreManager.userPassword.toString()) {
            NavigateLiveData.loggedUserLiveData.postValue(User(userEmail, userPassword))
        }
    }

}

