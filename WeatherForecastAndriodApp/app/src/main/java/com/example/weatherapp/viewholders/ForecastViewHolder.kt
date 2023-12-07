package com.example.weatherapp.viewholders;

import android.view.View;
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R

class ForecastViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val forecastDateTextView: TextView = view.findViewById(R.id.view_holder_date_textview)
    val forecastTempTextView: TextView = view.findViewById(R.id.view_holder_temp_textview)
    val forecastDescriptionTextView: TextView = view.findViewById(R.id.view_holder_description_textview)
    val forecastWindTextView: TextView = view.findViewById(R.id.view_holder_wind_textview)
    val forecastPOPTextView: TextView = view.findViewById(R.id.view_holder_pop_textview)
    val forecastIconImageView: ImageView = view.findViewById(R.id.view_holder_icon_imageView)

    fun resetViews() {
        forecastDateTextView.text = ""
        forecastTempTextView.text = ""
        forecastDescriptionTextView.text = ""
        forecastWindTextView.text = ""
        forecastPOPTextView.text = ""
        forecastIconImageView.setImageDrawable(AppCompatResources.getDrawable(
            view.context,
            R.drawable.baseline_image_not_supported_24)
        )
    }
}
