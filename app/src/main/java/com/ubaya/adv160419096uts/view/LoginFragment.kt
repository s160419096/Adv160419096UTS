package com.ubaya.adv160419096uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.Navigation
import com.google.android.material.textfield.TextInputEditText
import com.ubaya.adv160419096uts.R

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnLogin = view.findViewById<Button>(R.id.btnLogin)
//        val txtUsername = view.findViewById<TextInputEditText>(R.id.txtUsername)
//        val txtPassword = view.findViewById<TextInputEditText>(R.id.txtPassword)

        btnLogin.setOnClickListener {
//            val username = txtUsername.text.toString()

            val action = LoginFragmentDirections.actionProfileFragment()
            Navigation.findNavController(it).navigate(action)

        }

    }
}