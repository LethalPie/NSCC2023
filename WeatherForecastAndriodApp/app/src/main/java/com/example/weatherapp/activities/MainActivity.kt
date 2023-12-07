package com.example.weatherapp.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapp.R

class MainActivity : AppCompatActivity() {

    /** Init values */
    // Fields for our UI widgets
    private lateinit var predictButton: Button
    private lateinit var cityEditText: EditText
    private lateinit var progressBar: ProgressBar

    /** Override Methods */
    // Setup our UI
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeViews()
        configurePredictButton()
    }

    /** Utility Methods */
    // Initialize all views
    private fun initializeViews() {
        setSupportActionBar(findViewById(R.id.activity_main_toolbar))
        predictButton = findViewById(R.id.activity_main_predict_button)
        cityEditText = findViewById(R.id.activity_main_enter_city_edit_text)
        progressBar = findViewById(R.id.activity_main_progressBar)
    }

    // Launch predict activity passing city to intent
    private fun configurePredictButton() {
        predictButton.setOnClickListener {
            startActivity(
                PredictionActivity.newIntent(
                    this@MainActivity,
                    cityEditText.text.toString()
                )
            )
        }
    }

    companion object {
        const val TAG = "MainActivity"
    }
}
