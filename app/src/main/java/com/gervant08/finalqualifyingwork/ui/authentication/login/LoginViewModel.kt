package com.gervant08.finalqualifyingwork.ui.authentication.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.gervant08.finalqualifyingwork.model.repository.AuthRepository
import com.google.firebase.auth.FirebaseUser


class LoginViewModel(application: Application) : AndroidViewModel(application) {
    private val authRepository: AuthRepository = AuthRepository(application)
    private val userLiveData: MutableLiveData<FirebaseUser> = authRepository.getUserLiveData()

    fun login(email: String, password: String){

    }

    fun registration(email: String, password: String){

    }

    fun logOut(){
        authRepository.lodOut()
    }


    fun getUserLiveData(): MutableLiveData<FirebaseUser> = userLiveData

}