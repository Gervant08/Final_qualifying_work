package com.gervant08.finalqualifyingwork.ui.authentication.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.gervant08.finalqualifyingwork.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginFragment : Fragment() {
    lateinit var buttonToRegistration: Button
    private lateinit var passwordEditText: TextInputLayout
    private lateinit var passwordEditText1: TextInputEditText
    private lateinit var loginEditText: TextInputLayout
//    private val authViewModel: LoginViewModel by viewModels { LoginViewModelFactory() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_login_page, container, false)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewpager)
        buttonToRegistration = view.findViewById(R.id.go_to_registration)
        buttonToRegistration.setOnClickListener {
            viewPager?.currentItem = 1
        }

        return view
    }
}