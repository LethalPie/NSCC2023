package com.example.weatherapp.persistence.entities

import androidx.room.Entity

@Entity
data class Condition (
    var text: String,
    var icon: String
)