package com.alijan.newsapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.alijan.newsapp.databinding.ActivityMainBinding
import com.alijan.newsapp.ui.bookmark.BookmarkFragment
import com.alijan.newsapp.ui.explore.ExploreFragment
import com.alijan.newsapp.ui.home.HomeFragment
import com.alijan.newsapp.ui.profile.ProfileFragment
import com.alijan.newsapp.util.gone
import com.alijan.newsapp.util.visible

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createBottomNavigation()

    }

    private fun createBottomNavigation(){
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        NavigationUI.setupWithNavController(binding.bottomNavigationView,navHostFragment.navController)

        navHostFragment.navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.onboardingFragment, R.id.signInFragment, R.id.signUpFragment, R.id.detailFragment -> {
                    binding.bottomNavigationView.gone()
                }
                else -> binding.bottomNavigationView.visible()
            }
        }
    }

}