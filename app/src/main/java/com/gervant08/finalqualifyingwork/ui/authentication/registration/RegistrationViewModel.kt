package com.gervant08.finalqualifyingwork.ui.authentication.registration

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gervant08.finalqualifyingwork.model.data.User
import com.gervant08.finalqualifyingwork.model.data.DataStoreManager

class RegistrationViewModel(private val dataStoreManager: DataStoreManager) : ViewModel() {
    private val registeredUserLiveData: MutableLiveData<User> = MutableLiveData()

    suspend fun registration(email: String, password: String) {
        dataStoreManager.writeData(email, password)
        registeredUserLiveData.postValue(User(email, password))
    }

    fun getRegisteredUserLiveData(): MutableLiveData<User> = registeredUserLiveData
}