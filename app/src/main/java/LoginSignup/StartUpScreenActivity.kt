package LoginSignup

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.util.Pair
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.lukpheakdey.cityguideapp.R
import kotlinx.android.synthetic.main.activity_start_up_screen.*

class StartUpScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_up_screen)
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
}