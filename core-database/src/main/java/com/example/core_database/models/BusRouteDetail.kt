package com.example.core_database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bus_route_detail")
class BusRouteDetail(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    var routeId: String = "",
    var routeNumber: String = "",
    val routeName: String = "",
    var routeDescription: String? = null
)
