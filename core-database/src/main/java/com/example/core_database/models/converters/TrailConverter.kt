package com.example.core_database.models.converters

import androidx.room.TypeConverter
import com.example.core_database.models.Trail
import com.google.gson.Gson

class TrailConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromTrails(Trails: String?): List<Trail> {
        if (Trails == null) {
            return emptyList()
        }
        return gson.fromJson(Trails, Array<Trail>::class.java).asList()
    }

    @TypeConverter
    fun toTrails(listOfTrail: List<Trail>): String? {
        return gson.toJson(listOfTrail)
    }

}