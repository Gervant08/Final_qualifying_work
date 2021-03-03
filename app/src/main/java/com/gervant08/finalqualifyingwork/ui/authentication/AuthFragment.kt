package com.gervant08.finalqualifyingwork.ui.authentication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.gervant08.finalqualifyingwork.R
import com.gervant08.finalqualifyingwork.model.data.DataStoreManager


class AuthFragment(dataStoreManager: DataStoreManager) : Fragment() {

    private val authViewModel: AuthViewModel by viewModels { AuthViewModelFactory(dataStoreManager) }
    private lateinit var authViewPager: ViewPager2

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_auth, container, false)

        authViewPager = view.findViewById(R.id.viewpager)
        authViewPager.adapter = initAdapter()

        return view
    }

    private fun initAdapter(): FragmentStateAdapter = AuthFragmentPagerAdapter(
            authViewModel.initFragmentList(),
            requireActivity().supportFragmentManager,
            lifecycle
    )


}