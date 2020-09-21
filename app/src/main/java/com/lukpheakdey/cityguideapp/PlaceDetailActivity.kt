package com.lukpheakdey.cityguideapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_place_detail.*

class PlaceDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_detail)

        val name = intent.getStringExtra("PLACE_NAME")
        val star = intent.getStringExtra("PLACE_STAR")
        val desc = intent.getStringExtra("PLACE_DESC")
        val address = intent.getStringExtra("PLACE_ADDRESS")
        val phone = intent.getStringExtra("PLACE_PHONE")
        val open_time = intent.getStringExtra("OPEN_TIME")
        val close_time = intent.getStringExtra("CLOSE_TIME")
        val day_open = intent.getStringExtra("DAY_OPEN")
        val day_close = intent.getStringExtra("DAY_CLOSE")
        val map_url = intent.getStringExtra("MAP_URL")
        val image_url = intent.getStringExtra("IMAGE_URL")
        val open_day = "Open : ${open_time} | Close: ${close_time} | Day Open: ${day_open} | Day Close: ${day_close}"

        place_detail_title.text = name.toString()
        all_place_rating.rating = star.toFloat()
        place_detail_address.text = address.toString()
        place_detail_desc.text = desc.toString()
        place_detail_phone.text = phone.toString()
        place_detail_hour_open.text = open_day.toString()
        Glide.with(this).load(image_url.toString()).into(place_detail_image)
    }
}