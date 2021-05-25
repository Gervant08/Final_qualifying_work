package com.gervant08.finalqualifyingwork.ui.authentication.login

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.gervant08.finalqualifyingwork.R
import com.google.android.material.textfield.TextInputEditText

class LoginFragment : Fragment(R.layout.fragment_login_page) {

    private lateinit var registrationButton: Button
    private lateinit var loginButton: Button
    private lateinit var passwordEditText: TextInputEditText
    private lateinit var emailEditText: TextInputEditText

    private val viewModel: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
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
        val email = emailEditText.text.toString().filter { !it.isWhitespace() }
        val password = passwordEditText.text.toString().filter { !it.isWhitespace() }

        if (email.isNotEmpty() && password.isNotEmpty())
            viewModel.login(email, password)

    }
}