package com.alijan.newsapp.ui.onboarding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alijan.newsapp.R
import com.alijan.newsapp.databinding.ItemOnboardingBinding
import com.alijan.newsapp.data.model.OnboardingModel

class OnboardingAdapter: RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder>() {

    private val onboardingList = arrayListOf<OnboardingModel>(
        OnboardingModel(R.drawable.onboarding_1,"Stay Ahead with Breaking News Alerts","Get Instant Updates on Top Stories Anytime, Anywhere"),
        OnboardingModel(R.drawable.onboarding_2,"Dive Deeper into Current Events","Explore In-Depth Analysis and Expert Commentary"),
        OnboardingModel(R.drawable.onboarding_3,"Personalized News Experience","Tailored Content to Suit Your Interests and Preferences"),
    )

    inner class OnboardingViewHolder(val itemOnboardingBinding: ItemOnboardingBinding)
        : RecyclerView.ViewHolder(itemOnboardingBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
        val view = ItemOnboardingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OnboardingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return onboardingList.size
    }

    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {
        val item = onboardingList[position]
        holder.itemOnboardingBinding.item = item
    }
}