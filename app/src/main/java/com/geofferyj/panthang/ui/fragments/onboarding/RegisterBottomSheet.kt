package com.geofferyj.panthang.ui.fragments.onboarding

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.geofferyj.panthang.R
import com.geofferyj.panthang.databinding.RegisterBottomSheetBinding
import com.geofferyj.panthang.utils.BaseBottomSheet
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class RegisterBottomSheet : BaseBottomSheet() {
    private lateinit var binding: RegisterBottomSheetBinding
    private lateinit var onClickListener: BottomSheetClickListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        onClickListener = parentFragment as BottomSheetClickListener
        binding = RegisterBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.pinView.addTextChangedListener {
            val s = binding.pinView.text.toString().length

            when{
                s == 5 -> binding.buttonProceed.isEnabled = true
                s > 0 -> binding.pinView.setItemBackgroundColor(requireContext().getColor(R.color.green_a5))
                else -> {
                    binding.buttonProceed.isEnabled = false
                    binding.pinView.setItemBackgroundColor(requireContext().getColor(R.color.white))
                }
            }
        }
        binding.buttonProceed.setOnClickListener {
            onClickListener.onProceedClicked()
        }

        binding.requestAccess.setOnClickListener {
            onClickListener.onRequestAccessClicked()
        }
    }

    interface BottomSheetClickListener{
        fun onProceedClicked()
        fun onRequestAccessClicked()
    }
}