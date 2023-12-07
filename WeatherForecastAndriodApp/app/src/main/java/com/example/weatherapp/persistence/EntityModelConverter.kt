package com.example.weatherapp.persistence

import com.example.weatherapp.models.ForecastResponse
import com.example.weatherapp.models.Location
import com.example.weatherapp.models.Forecast
import com.example.weatherapp.models.ForecastDay
import com.example.weatherapp.models.Day
import com.example.weatherapp.models.Condition

typealias ForecastResponseModel = ForecastResponse
typealias LocationModel = Location
typealias LocationEntity = com.example.weatherapp.persistence.entities.Location
typealias ForecastModel = Forecast
typealias ForecastDayModel = ForecastDay
typealias ForecastDayEntity = com.example.weatherapp.persistence.entities.ForecastDay
typealias DayModel = Day
typealias DayEntity = com.example.weatherapp.persistence.entities.Day
typealias ConditionModel = Condition
typealias ConditionEntity = com.example.weatherapp.persistence.entities.Condition

object EntityModelConverter {

    fun convertModelToEntity(model: ForecastResponseModel): ArrayList<ForecastDayEntity> {
        val resultArrayList = ArrayList<ForecastDayEntity>()
        for (fdm in model.forecast.forecastday) {
            resultArrayList.add(
                ForecastDayEntity (
                    date = fdm.date,
                    location = convertModelToEntity(model.location),
                    day = convertModelToEntity(fdm.day)
                )
            )
        }

        return resultArrayList
    }

    private fun convertModelToEntity(model: LocationModel): LocationEntity {
        return LocationEntity (
            name = model.name,
            region = model.region,
            country = model.country,
            lat = model.lat,
            lon = model.lon,
            localtime = model.localtime
        )
    }

    private fun convertModelToEntity(model: DayModel): DayEntity {
        return DayEntity(
            avgtemp_c = model.avgtemp_c,
            maxwind_kph = model.maxwind_kph,
            daily_chance_of_rain = model.daily_chance_of_rain,
            daily_chance_of_snow = model.daily_chance_of_snow,
            condition = convertModelToEntity(model.condition)
        )
    }

    private fun convertModelToEntity(model: ConditionModel): ConditionEntity {
        return ConditionEntity(
            text = model.text,
            icon = model.icon
        )
    }

    fun convertEntityToModel(entity: ArrayList<ForecastDayEntity>): ForecastResponseModel {
        val forecastDayModelArrayList = ArrayList<ForecastDayModel>()
        for (fde in entity) {
            forecastDayModelArrayList.add(
                ForecastDayModel(
                    fde.date,
                    convertEntityToModel(fde.day)
                )
            )
        }

        return ForecastResponseModel (
            location = convertEntityToModel(entity[0].location),
            forecast = ForecastModel(forecastDayModelArrayList)
        )
    }

    private fun convertEntityToModel(entity: LocationEntity): LocationModel {
        return LocationModel (
            name = entity.name,
            region = entity.region,
            country = entity.country,
            lat = entity.lat,
            lon = entity.lon,
            localtime = entity.localtime
        )
    }

    private fun convertEntityToModel(entity: DayEntity): DayModel {
        return DayModel(
            avgtemp_c = entity.avgtemp_c,
            maxwind_kph = entity.maxwind_kph,
            daily_chance_of_rain = entity.daily_chance_of_rain,
            daily_chance_of_snow = entity.daily_chance_of_snow,
            condition = convertEntityToModel(entity.condition)
        )
    }

    private fun convertEntityToModel(entity: ConditionEntity): ConditionModel {
        return ConditionModel(
            text = entity.text,
            icon = entity.icon
        )
    }
}