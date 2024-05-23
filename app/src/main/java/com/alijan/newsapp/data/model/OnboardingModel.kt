package com.alijan.newsapp.data.model

import androidx.annotation.DrawableRes

data class OnboardingModel(
    @DrawableRes val image: Int,
    val subTitle: String,
    val title: String,
) {
}