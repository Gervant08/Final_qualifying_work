package com.gervant08.finalqualifyingwork.ui.authentication.login

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gervant08.finalqualifyingwork.model.data.User
import com.gervant08.finalqualifyingwork.model.data.DataStoreManager

class LoginViewModel @ViewModelInject constructor(
    private val dataStoreManager: DataStoreManager
) : ViewModel() {
    private val loggedUserLiveData: MutableLiveData<User> = MutableLiveData()

    fun login(email: String, password: String) {
        val user: User = dataStoreManager.readEmailAndPassword()
        if (email == user.email && password == user.password) {
            loggedUserLiveData.postValue(User(email, password))
        }

    }

    fun getLoggedUserLiveData(): MutableLiveData<User> = loggedUserLiveData

}