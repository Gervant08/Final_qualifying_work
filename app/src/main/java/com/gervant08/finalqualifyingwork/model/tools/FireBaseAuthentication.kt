package com.gervant08.finalqualifyingwork.model.tools

import com.gervant08.finalqualifyingwork.model.data.NavigateLiveData
import com.google.firebase.auth.FirebaseAuth
import com.gervant08.finalqualifyingwork.model.data.User
import com.google.firebase.database.*

class FireBaseAuthentication {
    val database = FirebaseDatabase.getInstance().reference
    val auth: FirebaseAuth = FirebaseAuth.getInstance()

    companion object{
        const val USERS = "users"
    }

    fun login(userEmail: String, userPassword: String){
        auth.signInWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener {
            if (it.isSuccessful) {
                NavigateLiveData.loggedUserLiveData.value = true
            }
        }
    }

    fun registration(userEmail: String, userPassword: String){
        auth.createUserWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener{ completeRegistration ->
            if (completeRegistration.isSuccessful) {
                val user = User(userEmail, userPassword)

                database.child("users").child(completeRegistration.result!!.user!!.uid).setValue(user).addOnCompleteListener {
                    if (it.isSuccessful){
                        NavigateLiveData.loggedUserLiveData.value = true
                    }
                }
            }
        }
    }
}