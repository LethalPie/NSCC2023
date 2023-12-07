package com.example.weatherapp.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object WeatherRetrofitAPI {

    private const val BASE_URL = "https://api.weatherapi.com/v1/"
    private const val TIMEOUT_DURATION = 30000L

    private val apiKeyInterceptor = Interceptor { chain ->
        val httpUrl = chain.request().url().newBuilder()
            .addQueryParameter("key", "53290856a9844a69941131001232111")
            .build()

        val request = chain.request().newBuilder()
            .url(httpUrl)
            .build()

        chain.proceed(request)
    }

    private val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val okHttpClient = OkHttpClient().newBuilder()
        .addInterceptor(apiKeyInterceptor)
        .addInterceptor(loggingInterceptor)
        .callTimeout(TIMEOUT_DURATION, TimeUnit.MILLISECONDS)
        .build()

    private fun buildRetrofit() = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val weatherApiService: WeatherApiService = buildRetrofit().create(WeatherApiService::class.java)

    // Add functionality
    suspend fun getForecastResponse(query: String, number: Int) = weatherApiService.getForecastResponse(query, number)
}