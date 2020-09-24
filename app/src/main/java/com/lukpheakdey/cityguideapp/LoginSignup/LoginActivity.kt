package com.lukpheakdey.cityguideapp.LoginSignup

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.lukpheakdey.cityguideapp.R
import com.lukpheakdey.cityguideapp.UserDashboardActivity
import com.lukpheakdey.cityguideapp.model.Categories
import com.lukpheakdey.cityguideapp.model.Place
import com.lukpheakdey.cityguideapp.viewmodel.CategoriesViewModel
import com.lukpheakdey.cityguideapp.viewmodel.PlaceViewModel
import com.lukpheakdey.cityguideapp.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var mUserViewModel: UserViewModel

    private lateinit var mCategoriesViewModel: CategoriesViewModel

    private lateinit var mPlaceViewModel: PlaceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mCategoriesViewModel = ViewModelProvider(this).get(CategoriesViewModel::class.java)
        mPlaceViewModel = ViewModelProvider(this).get(PlaceViewModel::class.java)

        btn_login.setOnClickListener {
            val email = et_login_email.editText?.text.toString().trim()
            val password = et_login_password.editText?.text.toString().trim()

            if(inputCheck(email, password)){
                var userpassword = mUserViewModel.findUserByEmailPassword(email, password)
                userpassword.observe(this, Observer { emailandpassword ->
                   if(emailandpassword.isEmpty()){
                       Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
                   } else {
                       sharePreferenceEmailPassword(email, password)
                       // call user dashboard intent
                       userDashboard()
                       Toast.makeText(this, "Sucessfully login", Toast.LENGTH_SHORT).show()
                   }
                })
            } else {
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
            }
        }

        login_back_button.setOnClickListener {
            //super.onBackPressed()
            userDashboard()
        }

        create_account_btn.setOnClickListener {
            var intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun inputCheck(email: String, password: String): Boolean {
        return !(TextUtils.isEmpty(email) && TextUtils.isEmpty(password))
    }

    fun sharePreferenceEmailPassword(email: String, password: String) {
        val spf = getSharedPreferences("myuserpassword", Context.MODE_PRIVATE)
        val spe = spf.edit()
        // Using put method to write the data in SharedPreferences
        spe.putString("email", email)
        spe.putString("password", password)
        spe.apply()
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

    fun userDashboard() {
        var intent = Intent(this, UserDashboardActivity::class.java)
        startActivity(intent)
    }
}