package com.project.destma.network.service

import com.project.destma.domain.model.Destination
import retrofit2.http.GET

interface DestinationService {

    @GET("/destinations")
    suspend fun getDestinations(): List<Destination>

}