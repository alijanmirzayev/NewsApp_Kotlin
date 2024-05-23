package com.alijan.newsapp.ui.home

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.alijan.newsapp.databinding.FragmentHomeBinding
import com.alijan.newsapp.util.gone
import com.alijan.newsapp.util.visible

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<HomeViewModel>()
    private val smallNewsCardAdapter = SmallNewsCardAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvHomeNewsCard.adapter = smallNewsCardAdapter

        observeData()

        smallNewsCardAdapter.onClick = {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(it))
        }
    }

    private fun observeData(){
        viewModel.newsList.observe(viewLifecycleOwner){
            smallNewsCardAdapter.updateList(it)
        }

        viewModel.isLoading.observe(viewLifecycleOwner){
            if(it){
                binding.progressBarNews.visible()
            } else {
                binding.progressBarNews.gone()
            }
        }

        viewModel.errorMessage.observe(viewLifecycleOwner){
            Toast.makeText(context,it.toString(),Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}