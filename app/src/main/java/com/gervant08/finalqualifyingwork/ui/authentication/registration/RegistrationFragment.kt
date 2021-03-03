package com.gervant08.finalqualifyingwork.ui.authentication.registration

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.gervant08.finalqualifyingwork.R
import com.gervant08.finalqualifyingwork.model.data.User
import com.gervant08.finalqualifyingwork.model.data.DataStoreManager
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegistrationFragment(
    dataStoreManager: DataStoreManager
) : Fragment(R.layout.fragment_reg_page) {

    private lateinit var passwordEditText: TextInputEditText
    private lateinit var emailEditText: TextInputEditText
    private lateinit var registrationButton: Button
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    private val registrationViewModel: RegistrationViewModel by viewModels {
        RegistrationViewModelFactory(dataStoreManager)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        registrationViewModel.getRegisteredUserLiveData().observe(this, this::onUsersChanged)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        registrationButton = view.findViewById(R.id.registration_button)
        emailEditText = view.findViewById(R.id.registration_input_mail)
        passwordEditText = view.findViewById(R.id.registration_input_pass)

        registrationButton.setOnClickListener {
            coroutineScope.launch {
                registration()
            }
        }

    }

    private suspend fun registration() {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        if (email.isNotEmpty() && password.isNotEmpty())
            registrationViewModel.registration(email, password)
        else {
            Toast.makeText(
                context,
                "Email Address and Password Must Be Entered",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun onUsersChanged(user: User) {
        Toast.makeText(context, "Reg", Toast.LENGTH_SHORT).show()
    }
}