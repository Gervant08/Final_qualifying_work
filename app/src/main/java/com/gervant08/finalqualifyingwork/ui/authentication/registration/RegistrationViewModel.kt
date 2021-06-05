package com.gervant08.finalqualifyingwork.ui.authentication.registration

import androidx.lifecycle.ViewModel
import com.gervant08.finalqualifyingwork.model.tools.FireBaseAuthentication

class RegistrationViewModel : ViewModel() {
    private val fireBaseAuthentication = FireBaseAuthentication()

    fun registration(email: String, password: String, userName: String, userLastName: String) {
        fireBaseAuthentication.registration(email, password, userName, userLastName)

    }
}