package com.lukpheakdey.cityguideapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_splash_screen.*
import android.view.animation.AnimationUtils;

class SplashScreenActivity : AppCompatActivity() {

    lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        background_image.animation = AnimationUtils.loadAnimation(this, R.anim.side_anim)
        powered_by_line.animation = AnimationUtils.loadAnimation(this, R.anim.slide_animation)

        handler = Handler()
        handler.postDelayed({
            // Delay and Start Activity
            val intent = Intent(this, OnBoardingActivity::class.java)
            startActivity(intent)
            finish()
        } , 3000) // here we're delaying to startActivity after 3seconds

    }
}