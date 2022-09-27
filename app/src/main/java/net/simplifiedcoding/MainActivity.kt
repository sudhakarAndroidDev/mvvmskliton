package net.simplifiedcoding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import net.simplifiedcoding.data.UserPreferences
import net.simplifiedcoding.ui.auth.AuthActivity
import net.simplifiedcoding.ui.home.HomeActivity
import net.simplifiedcoding.ui.startNewActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            startNewActivity(AuthActivity::class.java)
    }

}