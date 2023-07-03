package com.example.core_database.di

import android.content.Context
import androidx.room.Room
import com.example.core_database.db.RouteDatabase
import com.example.core_database.dao.RouteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    fun providesRouteDao(routeDatabase: RouteDatabase): RouteDao {
        return routeDatabase.routeDao()
    }

    @Provides
    fun providesRouteDatabase(@ApplicationContext applicationContext: Context): RouteDatabase {
        return Room.databaseBuilder(
            applicationContext,
            RouteDatabase::class.java,
            "route_database"
        ).allowMainThreadQueries().build()
    }
}