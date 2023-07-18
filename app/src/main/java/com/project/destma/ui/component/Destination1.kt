package com.project.destma.ui.component

import androidx.annotation.DrawableRes
import com.squareup.moshi.Json

data class Destination1(
    val id: String,
    val name: String,
    val description: String,
    val address: String,
    val imageUrl: String,
    val rating: Double,
    @DrawableRes val imageId: Int
)
