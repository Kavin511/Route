package com.example.core_database.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.core_database.models.converters.BusRouteDetailConverter
import com.example.core_database.models.converters.TrailConverter

@Entity(tableName = "route_table")
class Route(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    var sourceLat: Double,
    var sourceLong: Double,
    var sourceTitle: String,
    var sourceTime: String,
    var destinationLat: Double,
    var destinationLong: Double,
    var destinationTitle: String,
    var destinationTime: String,
    @TypeConverters(BusRouteDetailConverter::class)
    val busRouteDetails: List<BusRouteDetail>? = null,
    val medium: String,
    val duration: String,
    val fare: Double,
    val distance: Double,
    val routeName: String?,
    val rideEstimation: String? = null,
    @TypeConverters(TrailConverter::class)
    val trails: List<Trail>? = null,
)