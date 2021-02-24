package com.gervant08.finalqualifyingwork.model.repository

import android.app.Application
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class AuthRepository(private val application: Application) {
    private var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private var userLiveData: MutableLiveData<FirebaseUser> = MutableLiveData()
    private var loggedOutLiveData: MutableLiveData<Boolean> = MutableLiveData()

    init {
        if (firebaseAuth.currentUser != null) {
            userLiveData.postValue(firebaseAuth.currentUser);
            loggedOutLiveData.postValue(false);
        }
    }

    @RequiresApi(Build.VERSION_CODES.P)
    fun registration(email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(application.mainExecutor) {
                if (it.isSuccessful)
                    userLiveData.postValue(firebaseAuth.currentUser)
                else
                    Toast.makeText(
                        application.applicationContext,
                        "Registration Failure: " + it.exception?.message,
                        Toast.LENGTH_SHORT
                    ).show()

            }
    }

    @RequiresApi(Build.VERSION_CODES.P)
    fun login(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(application.mainExecutor) {
                if (it.isSuccessful)
                    userLiveData.postValue(firebaseAuth.currentUser)
                else
                    Toast.makeText(
                        application.applicationContext,
                        "Login Failure: " + it.exception?.message,
                        Toast.LENGTH_SHORT
                    ).show();
            }
    }

    fun lodOut() {
        firebaseAuth.signOut()
        loggedOutLiveData.postValue(true)
    }

    fun getUserLiveData(): MutableLiveData<FirebaseUser> = userLiveData


    fun getLoggedOutLiveData(): MutableLiveData<Boolean> = loggedOutLiveData



}