package com.ubaya.adv160419096uts.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.ubaya.adv160419096uts.R


class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val txtName = view.findViewById<TextView>(R.id.txtName)
//        if(arguments != null){
//            val username = ProfileFragmentArgs.fromBundle(requireArguments()).userName
//            txtName.text = "$username"
//        }

        val btnLogout = view.findViewById<Button>(R.id.btnLogout)
        val btnSettings = view.findViewById<Button>(R.id.btnSettings)
        val btnEditProfile = view.findViewById<Button>(R.id.btnEditProfile)

        btnSettings.setOnClickListener {
            val action = ProfileFragmentDirections.actionSettingFragment()
            Navigation.findNavController(it).navigate(action)
        }

        btnLogout.setOnClickListener {
            val action = ProfileFragmentDirections.actionLoginFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}