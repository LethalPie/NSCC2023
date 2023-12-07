package com.example.weatherapp.activities;

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.api.WeatherRetrofitAPI
import com.example.weatherapp.persistence.EntityModelConverter
import com.example.weatherapp.models.ForecastResponse
import com.example.weatherapp.persistence.AppDatabase
import com.example.weatherapp.adapters.ForecastAdapter
import com.example.weatherapp.models.ForecastDay
import com.example.weatherapp.persistence.ForecastDayEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class PredictionActivity : AppCompatActivity() {

    /** Init values */
    // Fields for our UI widgets
    private lateinit var predictToolbar: Toolbar
    private lateinit var progressBar: ProgressBar
    private lateinit var forecastRecyclerView: RecyclerView

    // Coroutine Setup
    private val coroutineContext = Job() + Dispatchers.Default
    private val coroutineScope = CoroutineScope(coroutineContext)

    // API args
    private var cityARG: String? = null // Init for city from Intent (processIntent())
    private val daysARG: Int = 3 // Hard coded Day value

    /** Override Methods */
    // Setup our UI & call API/Database
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prediction)

        initializeViews()
        processIntent()
        callForecastAPI() // Database/RecyclerView calls in method
    }

    // Toolbar support
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    /** Utility Methods */
    // Initialize all views
    private fun initializeViews() {
        setSupportActionBar(findViewById(R.id.activity_prediction_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        progressBar = findViewById(R.id.activity_prediction_progressBar)
        predictToolbar = findViewById(R.id.activity_prediction_toolbar)
    }

    // Processing intent to display the correct city from search
    private fun processIntent() {
        intent?.apply {
            cityARG = getStringExtra(EXTRA_CITY)
            if (!cityARG.isNullOrBlank())
                predictToolbar.title = cityARG
        }
    }

    // Call to API for the forecast
    private fun callForecastAPI() {
        progressBar.visibility = View.VISIBLE
        coroutineScope.launch {
            try {
                // API call
                val weatherResponse = WeatherRetrofitAPI.getForecastResponse(predictToolbar.title.toString(), daysARG)

                // Room database call
                persistForecast(weatherResponse)

                // Display with RecyclerView
                runOnUiThread {
                    displayForecast(weatherResponse.forecast.forecastday)
                }
            } catch (e: Exception) {
                runOnUiThread {
                    displayError(e, getString(R.string.API_fetch_error))
                }
            } finally {
                progressBar.visibility = View.INVISIBLE
            }
        }
    }

    // Room database insert
    private suspend fun persistForecast(forecastResponse: ForecastResponse) {
        var flag = false;
        if (progressBar.visibility != View.VISIBLE) {
            progressBar.visibility = View.VISIBLE
            flag = true
        }

        try {
            val forecastDayEntities: ArrayList<ForecastDayEntity> = EntityModelConverter.convertModelToEntity(forecastResponse)
            AppDatabase.getDatabase(this@PredictionActivity).ForecastDao().insertForecastDayCollection(forecastDayEntities)

        } catch (e: Exception) {
            runOnUiThread {
                displayError(e, getString(R.string.database_set_error))
            }

        } finally {
            if (flag) {
                progressBar.visibility = View.INVISIBLE
            }
        }
    }

    // Display Forecast Response using Recycler view
    private fun displayForecast(forecastDayArray: ArrayList<ForecastDay>) {
        forecastRecyclerView = findViewById(R.id.activity_prediction_forecast_recyclerView)
        forecastRecyclerView.layoutManager = LinearLayoutManager(this)
        forecastRecyclerView.adapter = ForecastAdapter(forecastDayArray)
    }

    // Display error
    private fun displayError(e: Exception, defaultMessage: String) {
        val message = e.message ?: defaultMessage
        Log.d(MainActivity.TAG, message)
        Toast.makeText(this@PredictionActivity, message, Toast.LENGTH_SHORT).show()
    }

    /** Companion object */
    companion object {
        // Intent companion objects
        private const val EXTRA_CITY = "com.example.weatherapp.predictionactivity.user_name"

        fun newIntent(context: Context, searchCity: String?) : Intent {
            return Intent(context, PredictionActivity::class.java).apply {
                searchCity?.let { city ->
                    putExtra(EXTRA_CITY, city)
                }
            }
        }

        const val TAG = "PredictionActivity"
    }
}
