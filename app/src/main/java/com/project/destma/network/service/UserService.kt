package com.project.destma.network.service

import com.project.destma.domain.model.User
import retrofit2.http.GET

interface UserService {

    @GET("/users")
    suspend fun getUsers(): List<User>

}