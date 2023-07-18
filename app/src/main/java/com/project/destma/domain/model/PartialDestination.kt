package com.project.destma.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
class PartialDestination(

    @ColumnInfo("r_id")
    val id: Long,

    @ColumnInfo("is_favorite")
    val isFavorite: Boolean

)