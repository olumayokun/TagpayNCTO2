package com.fowels.tagpayncto.ui.auth

import android.os.Build
import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.fowels.tagpayncto.R
import com.fowels.tagpayncto.data.network.AuthApi
import com.fowels.tagpayncto.data.network.Resource
import com.fowels.tagpayncto.data.repositories.AuthRepository
import com.fowels.tagpayncto.databinding.FragmentLoginBinding
import com.fowels.tagpayncto.databinding.FragmentRegistrationBinding
import com.fowels.tagpayncto.ui.base.BaseFragment


class RegistrationFragment : BaseFragment<AuthViewModel, FragmentRegistrationBinding, AuthRepository>() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {
                    Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_LONG).show()
                }
                is Resource.Failure -> {
                    Toast.makeText(requireContext(), "Login Failure", Toast.LENGTH_SHORT).show()
                }
            }
        })

        binding.buttonRegister.setOnClickListener {
            val code = binding.editTextTextCode.text.toString().trim()
            val email = binding.editTextTextEmailAddress.text.toString().trim()
            val imei = Settings.Secure.getString(requireContext().contentResolver, Settings.Secure.ANDROID_ID)
            val model = Build.MODEL
            val password = binding.editTextTextPassword.text.toString().trim()
            val pin = binding.editTextTextPin.text.toString().trim()

            //todo add validations
            viewModel.register(code, email, imei, model, password, pin,  false)
        }
    }

    override fun getViewModel() = AuthViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentRegistrationBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() = AuthRepository(remoteDataSource.buildApi(AuthApi::class.java))

}