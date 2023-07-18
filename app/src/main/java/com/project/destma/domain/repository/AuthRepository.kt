package com.project.destma.domain.repository

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import com.project.destma.utils.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    val currentUser: FirebaseUser?

    fun loginUser(email: String, password: String): Flow<Resource<AuthResult>>

    fun logoutUser() : Flow<Resource<Unit>>

    fun registerUser(name: String, email: String, password: String): Flow<Resource<AuthResult>>
}