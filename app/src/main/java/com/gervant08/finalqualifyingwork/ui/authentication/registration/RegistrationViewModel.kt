package com.gervant08.finalqualifyingwork.ui.authentication.registration

import androidx.lifecycle.ViewModel
import com.gervant08.finalqualifyingwork.model.data.CurrentUser
import com.gervant08.finalqualifyingwork.model.data.User
import com.gervant08.finalqualifyingwork.model.tools.FireBaseAuthentication

class RegistrationViewModel : ViewModel() {
    private val fireBaseAuthentication = FireBaseAuthentication()

    fun registration(email: String, password: String) {
        CurrentUser.user = User(email, password)
        fireBaseAuthentication.registration(email, password)

    }
}