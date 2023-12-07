package com.example.weatherapp.models

data class ForecastResponse (
    var location: Location,
    var forecast: Forecast
)