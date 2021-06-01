package com.gervant08.finalqualifyingwork.ui.main.profile

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.gervant08.finalqualifyingwork.R
import com.gervant08.finalqualifyingwork.model.data.User
import com.gervant08.finalqualifyingwork.model.tools.FireBaseAuthentication
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private val fireBaseAuthentication = FireBaseAuthentication()
    private val authentication = fireBaseAuthentication.auth
    private val fireBaseAuthenticationReference = fireBaseAuthentication.database

//    private val viewModel: ProfileViewModel by viewModels<ProfileViewModel> ()
    private lateinit var avatar: ImageView
    private lateinit var name: TextInputEditText
    private lateinit var lastName: TextInputEditText
    private lateinit var email: TextInputEditText
    private lateinit var phone: TextInputEditText
    private lateinit var editButton: ImageButton
    private lateinit var state: ProfileState

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        state = ProfileState.SAVE
        avatar = view.findViewById(R.id.profileAvatar)
        name = view.findViewById(R.id.profileInputName)
        lastName = view.findViewById(R.id.profileInputLastName)
        email = view.findViewById(R.id.profileInputMail)
        phone = view.findViewById(R.id.profileInputPhone)
        editButton = view.findViewById(R.id.profileEditProfileButton)
        getUser()
        editButton.setOnClickListener { editProfile() }
    }

    private fun editProfile() {

        when(state){
            ProfileState.SAVE -> {
                state = ProfileState.EDIT
                name.isEnabled = true
                lastName.isEnabled = true
                email.isEnabled = true
                phone.isEnabled = true
            }
            ProfileState.EDIT -> {
                state = ProfileState.SAVE
                name.isEnabled = false
                lastName.isEnabled = false
                email.isEnabled = false
                phone.isEnabled = false
            }
        }
    }


    private fun getUser() {
        fireBaseAuthenticationReference
            .child(authentication.currentUser!!.uid)
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val user = snapshot.getValue(User::class.java)
                    Toast.makeText(requireContext(), "НАКОНЕЦ-ТО КАК Я УЖЕ ЗАЕБАЛСЯ", Toast.LENGTH_SHORT).show()
                    name.setText(user!!.name, TextView.BufferType.EDITABLE)
                    lastName.setText(user.lastname, TextView.BufferType.EDITABLE)
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.d("ProfileFragment", "ddd")
                    name.setText(error.message, TextView.BufferType.EDITABLE)
                    lastName.setText(error.message, TextView.BufferType.EDITABLE)
                }

            })

    }

    enum class ProfileState{
        EDIT,
        SAVE
    }

}