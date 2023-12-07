package com.example.weatherapp.models

data class Location (
    var name: String,
    var region: String,
    var country: String,
    var lat: Float,
    var lon: Float,
    var localtime: String
)