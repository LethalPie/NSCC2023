package com.example.weatherapp.persistence.entities

import androidx.room.Embedded
import androidx.room.Entity

@Entity
data class Day (
    var avgtemp_c: Float,
    var maxwind_kph: Float,
    var daily_chance_of_rain: Float,
    var daily_chance_of_snow: Float,
    @Embedded(prefix = "con_") var condition: Condition
)