package com.example.weatherapp.persistence.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ForecastDay (
    var date: String,
    @Embedded(prefix = "loc_") var location: Location,
    @Embedded(prefix = "day_") var day: Day
)  {
    @PrimaryKey(autoGenerate = true) var id: Long? = null
}
