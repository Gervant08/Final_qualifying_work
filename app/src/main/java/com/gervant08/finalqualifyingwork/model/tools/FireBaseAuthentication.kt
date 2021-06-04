package com.gervant08.finalqualifyingwork.model.tools

import com.gervant08.finalqualifyingwork.model.data.NavigateLiveData
import com.google.firebase.auth.FirebaseAuth
import com.gervant08.finalqualifyingwork.model.data.User
import com.google.firebase.database.*

class FireBaseAuthentication {
    val database = FirebaseDatabase.getInstance().getReference("users")
    val auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun login(userEmail: String, userPassword: String){
        auth.signInWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener {
            if (it.isSuccessful) {
                NavigateLiveData.loggedUserLiveData.value = true
            }
        }
    }

    fun registration(userEmail: String, userPassword: String, userName: String, userLastName: String){
        auth.createUserWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener{ completeRegistration ->
            if (completeRegistration.isSuccessful) {
                val user = User(userName, userLastName)

                database.child(completeRegistration.result!!.user!!.uid).setValue(user).addOnCompleteListener {
                    if (it.isSuccessful){
                        NavigateLiveData.loggedUserLiveData.value = true
                    }
                }
            }
        }
    }

    fun updateUserInfo(){

    }
}