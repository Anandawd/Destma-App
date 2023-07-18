package com.project.destma.domain.repository

import com.project.destma.domain.model.Destination
import kotlinx.coroutines.flow.Flow

interface DestinationRepository {

    fun getDestinations(): Flow<List<Destination>>

    fun getDestination(id: Long): Flow<Destination>
}