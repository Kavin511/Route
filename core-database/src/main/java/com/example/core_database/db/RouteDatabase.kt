package com.example.core_database.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.core_database.dao.RouteDao
import com.example.core_database.models.Route

@Database(entities = [Route::class], version = 1, exportSchema = false)
abstract class RouteDatabase : RoomDatabase() {
    abstract fun routeDao(): RouteDao

    companion object {
        @Volatile
        private var instance: RouteDatabase? = null

        fun getInstance(context: Context): RouteDatabase? {
            if (instance == null) {
                synchronized(RouteDatabase::class.java) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RouteDatabase::class.java,
                        "notes"
                    )
                        .build()
                }
            }
            return instance
        }
    }