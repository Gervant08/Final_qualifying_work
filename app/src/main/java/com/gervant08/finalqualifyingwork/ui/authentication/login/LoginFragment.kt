package com.gervant08.finalqualifyingwork.ui.authentication.login

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.gervant08.finalqualifyingwork.R
import com.gervant08.finalqualifyingwork.model.data.User
import com.gervant08.finalqualifyingwork.model.data.DataStoreManager
import com.google.android.material.textfield.TextInputEditText

class LoginFragment(
    dataStoreManager: DataStoreManager
) : Fragment(R.layout.fragment_login_page) {

    private lateinit var registrationButton: Button
    private lateinit var loginButton: Button
    private lateinit var passwordEditText: TextInputEditText
    private lateinit var emailEditText: TextInputEditText

    private val loginViewModel: LoginViewModel by viewModels {
        LoginViewModelFactory(dataStoreManager)
    }


    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewpager)
        registrationButton = view.findViewById(R.id.login_button_registration)
        loginButton = view.findViewById(R.id.login_button_login)
        emailEditText = view.findViewById(R.id.login_input_login)
        passwordEditText = view.findViewById(R.id.login_input_password)

        registrationButton.setOnClickListener {
            viewPager?.currentItem = 1
        }

        loginButton.setOnClickListener {
            login()
        }
    }

    private fun login() {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        if (email.isNotEmpty() && password.isNotEmpty())
            loginViewModel.login(email, password)

    }

    private fun onUsersChanged(user: User) {
        Toast.makeText(context, "${user.email}", Toast.LENGTH_SHORT).show()
    }
}