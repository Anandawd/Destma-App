package com.project.destma.network.database

import androidx.compose.animation.core.repeatable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
class UserEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo("name") val name: String,
    @ColumnInfo("email") val email: String,
    @ColumnInfo("password") val password: String
)
