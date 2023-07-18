package com.project.destma.domain.repository

import com.project.destma.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getUsers(): Flow<List<User>>

    fun getUser(id: Long): Flow<User>

}