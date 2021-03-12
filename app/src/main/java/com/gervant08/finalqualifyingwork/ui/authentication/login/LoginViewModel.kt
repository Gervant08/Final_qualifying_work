package com.gervant08.finalqualifyingwork.ui.authentication.login

import androidx.lifecycle.ViewModel
import com.gervant08.finalqualifyingwork.model.data.User
import com.gervant08.finalqualifyingwork.model.data.DataStoreManager
import com.gervant08.finalqualifyingwork.model.data.UserLiveData

class LoginViewModel (
    private val dataStoreManager: DataStoreManager
) : ViewModel() {

    fun login(email: String, password: String) {
        val user: User = dataStoreManager.readEmailAndPassword()
        if (email == user.email && password == user.password) {
            UserLiveData.loggedUserLiveData.postValue(User(email, password))
        }

    }

}