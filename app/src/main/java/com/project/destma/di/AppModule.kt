package com.project.destma.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.storage.FirebaseStorage
import com.project.destma.domain.repository.AuthRepository
import com.project.destma.domain.repository.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFirebaseAuth() = FirebaseAuth.getInstance()

//    @Provides
//    @Singleton
//    fun provideFirebaseFirestore(): FirebaseFirestore {
//        return FirebaseFirestore.getInstance()
//    }

    @Provides
    @Singleton
    fun provideFirebaseStorage():FirebaseStorage{
        return FirebaseStorage.getInstance()
    }

    @Provides
    @Singleton
    fun provideRepositoryImpl(firebaseAuth: FirebaseAuth): AuthRepository {
        return AuthRepositoryImpl(firebaseAuth)
    }



}