package com.ubaya.adv160419096uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.ubaya.adv160419096uts.R

class EditProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnBackEditProfile = view.findViewById<Button>(R.id.btnBackEditProfile)
        btnBackEditProfile.setOnClickListener {
//            val action = EditProfileFragmentDirections.actionEditToProfileFragment()
//            Navigation.findNavController(it).navigate(action)
        }
    }
}