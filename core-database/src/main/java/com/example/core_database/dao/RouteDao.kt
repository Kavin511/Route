package com.example.core_database.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.IGNORE
import com.example.core_database.models.Route
import kotlinx.coroutines.flow.Flow

@Dao
interface RouteDao {
    @Query("SELECT * FROM  route_table order by id DESC")
    fun getAllRouteAsStream(): Flow<List<Route>>

    @Query("SELECT * FROM route_table order by id DESC")
    fun getRoutes(): List<Route>

    @Insert(onConflict = IGNORE)
    suspend fun insertRouteFromJson(route: Route)
}