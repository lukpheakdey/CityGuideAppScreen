package com.lukpheakdey.cityguideapp.LoginSignup

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Pair
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.lukpheakdey.cityguideapp.R
import com.lukpheakdey.cityguideapp.UserDashboardActivity
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.activity_start_up_screen.*
import kotlinx.android.synthetic.main.activity_start_up_screen.signup_btn
import kotlinx.android.synthetic.main.activity_user_dashboard.*

class StartUpScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_up_screen)

        if(isLogin()){
            login_btn?.setVisibility(View.GONE)
            signup_btn?.setVisibility(View.GONE)
        }
        else {
            login_out_btn?.setVisibility(View.GONE)
        }

        login_out_btn.setOnClickListener {
            logout()
            var intent = Intent(this, UserDashboardActivity::class.java)
            startActivity(intent)
        }

    }

    fun callLoginScreen(view: View) {
        var intent  = Intent(this, LoginActivity::class.java)
        val p1 = Pair.create<View?, String?>(login_btn, "transition_login")
        val options = ActivityOptions.makeSceneTransitionAnimation(this, p1)
        startActivity(intent, options.toBundle())
    }
    
    fun callSignupScreen(view: View) {
        var intent = Intent(this, SignUpActivity::class.java)
        val p2 = Pair.create<View?, String?>(signup_btn, "transition_signup")
        val options = ActivityOptions.makeSceneTransitionAnimation(this, p2)
        startActivity(intent, options.toBundle())
    }

    fun isLogin() : Boolean {
        val spf = getSharedPreferences("myuserpassword", Context.MODE_PRIVATE)
        val email = spf.getString("email", null)
        val password = spf.getString("password", null)
        if(email!=null && password!=null) {
            return true
        }
        return false
    }

    fun logout() {
        val spf = getSharedPreferences("myuserpassword", Context.MODE_PRIVATE)
        val spe = spf.edit()
        spe.clear()
        spe.apply()
        finish()
        Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show()
    }
}