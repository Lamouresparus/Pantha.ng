package com.geofferyj.panthang.ui.fragments.onboarding

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.geofferyj.panthang.databinding.OnboardingFragmentBinding

class OnBoardingFragment : Fragment(), RegisterBottomSheet.BottomSheetClickListener {

    lateinit var binding: OnboardingFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = OnboardingFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.registerBtn.setOnClickListener {
            showBottomSheet()
        }
    }

    private fun showBottomSheet() {
        RegisterBottomSheet().show(childFragmentManager, "BottomSheet")
    }

    override fun onProceedClicked() {
        Log.d("BottomSheet", "Proceed Clicked")
    }

    override fun onRequestAccessClicked() {
        Log.d("BottomSheet", "request Clicked")

    }
}