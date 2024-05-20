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

    private val homeFragment = HomeFragment()
    private val exploreFragment = ExploreFragment()
    private val bookmarkFragment = BookmarkFragment()
    private val profileFragment = ProfileFragment()
    private var activeFragment: Fragment = homeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addFragments()
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

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.homeFragment -> {
                    supportFragmentManager.beginTransaction().hide(activeFragment).show(homeFragment).commit()
                    activeFragment = homeFragment
                    true
                }
                R.id.exploreFragment -> {
                    supportFragmentManager.beginTransaction().hide(activeFragment).show(exploreFragment).commit()
                    activeFragment = exploreFragment
                    true
                }
                R.id.bookmarkFragment -> {
                    supportFragmentManager.beginTransaction().hide(activeFragment).show(bookmarkFragment).commit()
                    activeFragment = bookmarkFragment
                    true
                }
                R.id.profileFragment -> {
                    supportFragmentManager.beginTransaction().hide(activeFragment).show(profileFragment).commit()
                    activeFragment = profileFragment
                    true
                }
                else -> false
            }
        }
    }

    private fun addFragments(){
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainerView,homeFragment, "home").hide(homeFragment).commit()
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainerView,exploreFragment, "explore").hide(exploreFragment).commit()
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainerView,bookmarkFragment,"bookmark").hide(bookmarkFragment).commit()
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainerView,profileFragment,"profile").hide(profileFragment).commit()

    }
}