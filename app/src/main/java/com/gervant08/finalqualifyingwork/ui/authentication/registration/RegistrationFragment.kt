package com.gervant08.finalqualifyingwork.ui.authentication.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gervant08.finalqualifyingwork.R
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener

class RegistrationFragment : Fragment() {
    private lateinit var passwordField: TextInputEditText
    private lateinit var loginField: TextInputEditText
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var  authListener: AuthStateListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_reg_page, container, false)
        return view
    }

}