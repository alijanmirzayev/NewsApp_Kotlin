package com.alijan.newsapp.ui.explore

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alijan.newsapp.R
import com.alijan.newsapp.databinding.FragmentExploreBinding
import com.alijan.newsapp.databinding.FragmentHomeBinding

class ExploreFragment : Fragment() {
    private var _binding: FragmentExploreBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("yasamDongusu","ExploreFragment -> onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("yasamDongusu","ExploreFragment -> onCreate")
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExploreBinding.inflate(inflater)
        Log.e("yasamDongusu","ExploreFragment -> onCreateView")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("yasamDongusu","ExploreFragment -> onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.e("yasamDongusu","ExploreFragment -> onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("yasamDongusu","ExploreFragment -> onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("yasamDongusu","ExploreFragment -> onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("yasamDongusu","ExploreFragment -> onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("yasamDongusu","ExploreFragment -> onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("yasamDongusu","ExploreFragment -> onDetach")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("yasamDongusu","ExploreFragment -> onDestroyView")
        _binding = null
    }
}