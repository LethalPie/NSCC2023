package com.example.weatherapp.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.weatherapp.persistence.ForecastDayEntity

@Dao
interface ForecastDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertForecastDayCollection(forecastDays: ArrayList<ForecastDayEntity>)

//    @Query("SELECT * FROM forecastday WHERE loc_name = :location")
//    suspend fun getForecastDayWhereLocation(location: String): ArrayList<ForecastDayEntity>
}
