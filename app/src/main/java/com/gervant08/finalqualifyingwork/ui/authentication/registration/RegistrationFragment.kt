package com.gervant08.finalqualifyingwork.ui.authentication.registration

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.gervant08.finalqualifyingwork.R
import com.google.android.material.textfield.TextInputEditText

class RegistrationFragment : Fragment(R.layout.fragment_reg_page) {

    private lateinit var registrationInputName : TextInputEditText
    private lateinit var registrationInputLastName : TextInputEditText
    private lateinit var registrationInputEmail: TextInputEditText
    private lateinit var registrationInputPassword: TextInputEditText
    private lateinit var registrationButton: Button

    private val registrationViewModel: RegistrationViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        registrationButton = view.findViewById(R.id.registrationButtonRegistration)
        registrationInputName = view.findViewById(R.id.registrationInputName)
        registrationInputLastName = view.findViewById(R.id.registrationInputLastName)
        registrationInputEmail = view.findViewById(R.id.registrationInputEmail)
        registrationInputPassword = view.findViewById(R.id.registrationInputPassword)

        registrationButton.setOnClickListener {
                registration()
        }
    }

    private fun registration() {
        val userName = registrationInputName.text.toString().filter { !it.isWhitespace() }
        val userLastName = registrationInputLastName.text.toString().filter { !it.isWhitespace() }
        val userEmail = registrationInputEmail.text.toString().filter { !it.isWhitespace() }
        val userPassword = registrationInputPassword.text.toString().filter { !it.isWhitespace() }

        if (userEmail.isNotEmpty() && userPassword.isNotEmpty())
            registrationViewModel.registration(userEmail, userPassword, userName, userLastName)
    }
}