package com.alijan.newsapp.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.alijan.newsapp.databinding.FragmentOnboardingBinding
import com.google.android.material.tabs.TabLayoutMediator

class OnboardingFragment : Fragment() {
    private var _binding: FragmentOnboardingBinding? = null
    private val binding get() = _binding!!
    private val adapter = OnboardingAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnboardingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPagerOnboarding.adapter = adapter
        // binding.viewPagerOnboarding.isUserInputEnabled = false

        TabLayoutMediator(
            binding.tabLayoutOnboarding,
            binding.viewPagerOnboarding
        ) { _, _ -> }.attach()


        binding.buttonOnboardingNext.setOnClickListener {
            changeOnboardingPage("next")
        }

        binding.buttonOnboardingBack.setOnClickListener {
            changeOnboardingPage("back")
        }
    }

    private fun changeOnboardingPage(buttonType: String) {
        val currentItem = binding.viewPagerOnboarding.currentItem

        if (buttonType == "next" && currentItem < 2) {
            binding.viewPagerOnboarding.currentItem += 1
        } else if (buttonType == "next" && currentItem == 2) {
            findNavController().navigate(OnboardingFragmentDirections.actionOnboardingFragmentToSignUpFragment())
        }

        if (buttonType == "back" && currentItem > 0) {
            binding.viewPagerOnboarding.currentItem -= 1
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}