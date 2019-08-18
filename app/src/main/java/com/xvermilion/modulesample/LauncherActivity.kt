package com.xvermilion.modulesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xvermilion.modulesample.navigation.HomeNavigation

class LauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        HomeNavigation.dynamicStart?.let { startActivity(it) }
        finish()
    }
}
