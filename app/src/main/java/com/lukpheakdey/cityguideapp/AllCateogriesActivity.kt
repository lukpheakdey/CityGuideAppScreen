package com.lukpheakdey.cityguideapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_all_cateogries.*

class AllCateogriesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_cateogries)

        //Back to user dashborad
        back_pressed.setOnClickListener {
            var i = Intent(applicationContext, UserDashboardActivity::class.java)
            startActivity(i)
        }

        // example
        press_restaurant.setOnClickListener {
            intentActionGo(1)
        }

        press_car_rent.setOnClickListener {
            intentActionGo(2)
        }

        press_hotel.setOnClickListener {
            intentActionGo(3)
        }

        press_education.setOnClickListener {
            intentActionGo(4)
        }

        press_shops.setOnClickListener {
            intentActionGo(5)
        }

    }

    fun intentActionGo(categoryId: Int) {
        var intent = Intent(applicationContext, AllPlacesActivity::class.java)
        intent.putExtra("CALL_FROM_CATEGORY", "call_from_category")
        intent.putExtra("CATEOGRY_ID", categoryId)
        startActivity(intent)
    }
}