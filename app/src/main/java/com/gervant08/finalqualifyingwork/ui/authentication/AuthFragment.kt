package com.gervant08.finalqualifyingwork.ui.authentication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.gervant08.finalqualifyingwork.R
import com.gervant08.finalqualifyingwork.model.data.DataStoreManager
import com.gervant08.finalqualifyingwork.model.data.User
import com.gervant08.finalqualifyingwork.model.data.UserLiveData
import com.gervant08.finalqualifyingwork.ui.main.MainFragment


class AuthFragment(dataStoreManager: DataStoreManager) : Fragment(R.layout.fragment_auth) {

    private val authViewModel: AuthViewModel by viewModels { AuthViewModelFactory(dataStoreManager) }
    private lateinit var authViewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        UserLiveData.loggedUserLiveData.observe(this, this::onUserLogged)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        authViewPager = view.findViewById(R.id.viewpager)
        authViewPager.adapter = initAdapter()
    }

    private fun initAdapter(): FragmentStateAdapter = AuthFragmentPagerAdapter(
            authViewModel.initFragmentList(),
            requireActivity().supportFragmentManager,
            lifecycle
    )

    private fun onUserLogged(user: User){
        authViewModel.logIn()
        requireFragmentManager().beginTransaction()
            .replace(R.id.container, MainFragment())
            .commit()
    }


}