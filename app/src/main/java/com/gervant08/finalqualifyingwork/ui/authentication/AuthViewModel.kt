package com.gervant08.finalqualifyingwork.ui.authentication

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.gervant08.finalqualifyingwork.ui.authentication.login.LoginFragment
import com.gervant08.finalqualifyingwork.ui.authentication.registration.RegistrationFragment


class AuthViewModel : ViewModel() {

    fun initFragmentList(): ArrayList<Fragment> =
            arrayListOf(
                    LoginFragment(),
                    RegistrationFragment()
            )

}