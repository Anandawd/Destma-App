package com.project.destma.network.service

import com.project.destma.domain.model.Destination
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DestinationApiService {

    @GET("destinations.json")
    suspend fun getDestinations(): List<Destination>

    @GET("destinations.json?orderBy=\"d_id\"")
    suspend fun getDestinaDtionById(@Query("equalTo") id: Long): Map<String, Destination>
}