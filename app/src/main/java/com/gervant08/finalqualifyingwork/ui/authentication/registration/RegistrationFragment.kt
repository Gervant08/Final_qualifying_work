package com.gervant08.finalqualifyingwork.ui.authentication.registration

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.gervant08.finalqualifyingwork.R
import com.gervant08.finalqualifyingwork.model.tools.UserPreferences
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegistrationFragment(
    dataStoreManager: UserPreferences
) : Fragment(R.layout.fragment_reg_page) {

    private lateinit var passwordEditText: TextInputEditText
    private lateinit var emailEditText: TextInputEditText
    private lateinit var registrationButton: Button

    private val registrationViewModel: RegistrationViewModel by viewModels {
        RegistrationViewModelFactory(dataStoreManager)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        registrationButton = view.findViewById(R.id.registration_button_registration)
        emailEditText = view.findViewById(R.id.registration_input_mail)
        passwordEditText = view.findViewById(R.id.registration_input_password)

        registrationButton.setOnClickListener {
                registration()
        }

    }

    private fun registration() {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        if (email.isNotEmpty() && password.isNotEmpty())
            registrationViewModel.registration(email, password)
    }
}