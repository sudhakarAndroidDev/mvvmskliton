package net.simplifiedcoding.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import net.simplifiedcoding.R
import net.simplifiedcoding.data.UserPreferences
import net.simplifiedcoding.data.network.RemoteDataSource
import net.simplifiedcoding.ui.auth.AuthActivity
import net.simplifiedcoding.ui.startNewActivity

class HomeActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


    }


}