package com.example.weatherapp.api

import com.example.weatherapp.models.ForecastResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {

    @GET("forecast.json")
    suspend fun getForecastResponse(@Query("q") query: String, @Query("days") number: Int): ForecastResponse
}