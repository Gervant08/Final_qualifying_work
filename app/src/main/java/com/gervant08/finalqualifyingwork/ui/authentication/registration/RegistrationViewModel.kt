package com.gervant08.finalqualifyingwork.ui.authentication.registration

import androidx.lifecycle.ViewModel
import com.gervant08.finalqualifyingwork.model.data.User
import com.gervant08.finalqualifyingwork.model.data.DataStoreManager
import com.gervant08.finalqualifyingwork.model.data.UserLiveData

class RegistrationViewModel(private val dataStoreManager: DataStoreManager) : ViewModel() {

    suspend fun registration(email: String, password: String) {
        dataStoreManager.writeData(email, password)
        UserLiveData.loggedUserLiveData.postValue(User(email, password))
    }
}