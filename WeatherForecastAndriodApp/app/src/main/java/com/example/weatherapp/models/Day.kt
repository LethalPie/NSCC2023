package com.example.weatherapp.models

data class Day (
    var avgtemp_c: Float,
    var maxwind_kph: Float,
    var daily_chance_of_rain: Float,
    var daily_chance_of_snow: Float,
    var condition: Condition
)