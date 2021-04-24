package com.geofferyj.panthang.ui.fragments.register

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.geofferyj.panthang.databinding.RegisterFragmentBinding

class RegisterFragment : Fragment() {
    private lateinit var binding: RegisterFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RegisterFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fullName.editText?.doOnTextChanged { _, _, _, _ ->
            binding.buttonProceed.isEnabled = canProceed()
            Log.d("RegisterFragment", "${canProceed()}")

        }

        binding.phoneNumber.editText?.doOnTextChanged { _, _, _, _ ->
            binding.buttonProceed.isEnabled = canProceed()
            Log.d("RegisterFragment", "${canProceed()}")

        }

        binding.email.editText?.doOnTextChanged { _, _, _, _ ->
            binding.buttonProceed.isEnabled = canProceed()
            Log.d("RegisterFragment", "${canProceed()}")

        }

        binding.password.editText?.doOnTextChanged { _, _, _, _ ->
            binding.buttonProceed.isEnabled = canProceed()
            Log.d("RegisterFragment", "${canProceed()}")

        }

        binding.confirmPassword.apply {
            editText?.doOnTextChanged { text, start, before, count ->
                val passwordIn = binding.password.editText?.text.toString()
                error = if (isPasswordTheSame(passwordIn, text.toString())) null else "passwords don't match"
                binding.buttonProceed.isEnabled = canProceed()
                Log.d("RegisterFragment", "${canProceed()}")
            }
        }

    }

    private fun isPasswordTheSame(password: String, confirmPassword: String): Boolean {
        return password == confirmPassword
    }

    private fun canProceed(): Boolean {
        val name = binding.fullName.editText?.text.toString()
        val phoneNumber = binding.phoneNumber.editText?.text.toString()
        val email = binding.email.editText?.text.toString()
        val password = binding.password.editText?.text.toString()
        val confirmPassword = binding.confirmPassword.editText?.text.toString()
        return name.isNotBlank() && phoneNumber.isNotBlank() && email.isNotBlank() && password.isNotBlank() && confirmPassword.isNotBlank() && isPasswordTheSame(
            password,
            confirmPassword
        )
    }
}