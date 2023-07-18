package com.project.destma.network.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.project.destma.domain.model.Destination
import com.project.destma.domain.model.User
import com.project.destma.network.dao.DestinationDao
import com.project.destma.network.dao.UserDao

@Database(entities = [Destination::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun destinationDao(): DestinationDao

    //abstract fun userDao(): UserDao

    abstract val destinationDao: DestinationDao

    companion object {
        @Volatile
        private var INSTANCE: DestinationDao? = null

        fun getDestinationInstance(context: Context): DestinationDao {
            synchronized(this){
                var instance = INSTANCE
                if(instance == null){
                    instance = buildDatabase(context).destinationDao
                    INSTANCE = instance
                }
                return instance
            }
        }

        private fun buildDatabase(context: Context): AppDatabase =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "app_database")
                .fallbackToDestructiveMigration()
                .build()

    }

}