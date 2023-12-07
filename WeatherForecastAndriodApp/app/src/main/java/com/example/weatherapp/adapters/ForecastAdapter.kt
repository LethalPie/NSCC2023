package com.example.weatherapp.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weatherapp.viewholders.ForecastViewHolder
import com.example.weatherapp.R
import com.example.weatherapp.persistence.ForecastDayModel

class ForecastAdapter(private val forecastDayModels: List<ForecastDayModel>): RecyclerView.Adapter<ForecastViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_forecast, parent, false)

        return ForecastViewHolder(view)
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.resetViews()
        val forecastDayModel = forecastDayModels[position]

        holder.apply {
            forecastDateTextView.text = itemView.context.getString(R.string.forecast_date, forecastDayModel.date)
            forecastTempTextView.text = itemView.context.getString(R.string.forecast_temp_c, forecastDayModel.day.avgtemp_c.toString())
            forecastDescriptionTextView.text = forecastDayModel.day.condition.text
            forecastWindTextView.text = itemView.context.getString(R.string.forecast_wind_kph, forecastDayModel.day.maxwind_kph.toString())
            val pop = forecastDayModel.day.daily_chance_of_rain + forecastDayModel.day.daily_chance_of_snow
            forecastPOPTextView.text = itemView.context.getString(R.string.forecast_pop, pop.toString())

            loadForecastIcon(
                view.context,
                forecastDayModel.day.condition.icon,
                forecastIconImageView
            )

            view.setOnClickListener {
                Log.d(TAG, "Forecast item clicked at position: $position")
            }
        }
    }

    private fun loadForecastIcon(context: Context, src: String, imageView: ImageView) {
        Glide
            .with(context)
            .load("https:".plus(src))
            .centerCrop()
            .placeholder(R.drawable.baseline_image_not_supported_24)
            .into(imageView)
    }

    override fun getItemCount(): Int = forecastDayModels.size

    companion object {
        const val TAG = "RecipePreviewAdapter"
    }
}