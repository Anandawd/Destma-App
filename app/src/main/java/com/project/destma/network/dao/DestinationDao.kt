package com.project.destma.network.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.project.destma.domain.model.Destination
import com.project.destma.domain.model.PartialDestination
import kotlinx.coroutines.flow.Flow

@Dao
interface DestinationDao {

    @Query("SELECT * FROM destination")
    suspend fun getAllDestination(): Flow<List<Destination>>

    @Query("SELECT * FROM user WHERE id = :destinationId")
    suspend fun getDestinationById(destinationId: Long): Flow<Destination>

    @Query("SELECT * FROM destination WHERE d_name LIKE '%' || :name || '%'")
    fun read(name: String): Flow<Destination>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDestinations(destinations: List<Destination>)

    @Update(entity = Destination::class)
    suspend fun updateDestination(partialDestination: PartialDestination)

    @Update(entity = Destination::class)
    suspend fun updateAllDestination(partialDestinations: List<PartialDestination>)

    @Query("SELECT * FROM destination WHERE is_favorite = 1")
    suspend fun getAllFavorite(): List<Destination>

    @Update
    suspend fun updateComment(destination: Destination)

    @Delete
    suspend fun deleteComment(destination: Destination)
}