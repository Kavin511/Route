package com.example.core_database.models

import androidx.room.Entity

@Entity(tableName = "trials_table")
class Trail(
    val name: String = "",
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val distance: Double = 0.0,
    val seq: Int = 1,
    val time: String? = "",
    val fareStage: String = "Y",
)