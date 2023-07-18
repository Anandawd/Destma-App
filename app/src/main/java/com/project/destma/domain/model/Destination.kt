package com.project.destma.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

import com.google.gson.annotations.SerializedName

@Entity(tableName = "destination")
data class Destination(

    @PrimaryKey
    @ColumnInfo("d_id")
    @SerializedName("d_id")
    val id: Long,

    @ColumnInfo("d_name")
    @SerializedName("d_name")
    val name: String,

    @ColumnInfo("d_description")
    @SerializedName("d_description")
    val description: String,

    @ColumnInfo("d_address")
    @SerializedName("d_address")
    val address: String,

    @ColumnInfo("d_imageUrl")
    @SerializedName("d_imageUrl")
    val imageUrl: String,

    @ColumnInfo("d_rating")
    @SerializedName("d_rating")
    val rating: Double,

    @ColumnInfo("d_category")
    @SerializedName("d_category")
    val category: String,

    @ColumnInfo("d_facility")
    @SerializedName("d_facility")
    val facility: List<String>,

    @ColumnInfo("is_favorite")
    var isFavorite: Boolean = false
)


/*
data class Destination(
    @Json(name = "id") val id: Long,
    @Json(name = "name") val name: String,
    @Json(name = "description") val description: String,
    @Json(name = "address") val address: String,
    @Json(name = "imageUrl") val imageUrl: String,
    @Json(name = "rating") val rating: Double
)

 */
