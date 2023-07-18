package com.project.destma.domain.model

import com.squareup.moshi.Json

data class User(
    @Json(name = "id") val id: Long,
    @Json(name = "name") val name: String,
    @Json(name = "email") val email: String,
    @Json(name = "password") val password: String,
    @Json(name = "imageUrl") val imageUrl: String
    )
