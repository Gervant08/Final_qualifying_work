package com.gervant08.finalqualifyingwork.ui.authentication.login

import androidx.lifecycle.ViewModel
import com.gervant08.finalqualifyingwork.model.tools.FireBaseAuthentication

class LoginViewModel: ViewModel() {
    private val fireBaseAuthentication = FireBaseAuthentication()

    fun login(userEmail: String, userPassword: String) {
        fireBaseAuthentication.login(userEmail, userPassword)
    }

}

