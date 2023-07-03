package com.example.core_database.models.converters

import androidx.room.TypeConverter
import com.example.core_database.models.BusRouteDetail
import com.google.gson.Gson

class BusRouteDetailConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromBusRouteDetails(busRouteDetails: String?): List<BusRouteDetail> {
        if (busRouteDetails == null) {
            return emptyList()
        }
        return gson.fromJson(busRouteDetails, Array<BusRouteDetail>::class.java).asList()
    }

    @TypeConverter
    fun toBusRouteDetails(listOfBusRouteDetail: List<BusRouteDetail>): String? {
        return gson.toJson(listOfBusRouteDetail)
    }

}

