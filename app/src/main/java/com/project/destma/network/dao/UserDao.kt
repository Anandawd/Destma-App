package com.project.destma.network.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.project.destma.network.database.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getUsers(): Flow<List<UserEntity>>

    @Query("SELECT * FROM user WHERE id = :userId")
    fun getUserById(userId: Long): Flow<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers(users: List<UserEntity>)

}