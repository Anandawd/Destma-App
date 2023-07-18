//package com.project.destma.di
//
//import android.content.Context
//import androidx.room.Room
//import com.project.destma.network.dao.DestinationDao
//import com.project.destma.network.dao.UserDao
//import com.project.destma.network.database.AppDatabase
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.qualifiers.ApplicationContext
//import dagger.hilt.components.SingletonComponent
//
//@Module
//@InstallIn(SingletonComponent::class)
//class PersistenceModule {
//
//    @Provides
//    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase = Room
//        .databaseBuilder(
//            context,
//            AppDatabase::class.java, "destma-database"
//        )
//        .build()
//
//    @Provides
//    fun provideUserDao(appDatabase: AppDatabase): UserDao = appDatabase
//        .userDao()
//
//    @Provides
//    fun provideDestinationDao(appDatabase: AppDatabase): DestinationDao = appDatabase
//        .destinationDao()
//
//
//}