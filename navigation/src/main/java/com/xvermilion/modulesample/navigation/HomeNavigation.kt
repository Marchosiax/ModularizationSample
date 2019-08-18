package com.xvermilion.modulesample.navigation

import android.content.Intent
import com.xvermilion.modulesample.navigation.loaders.loadIntentOrNull

object HomeNavigation : DynamicFeature<Intent> {

    private const val HOME = "com.xvermilion.modulesample.home.HomeActivity"

    override val dynamicStart: Intent?
        get() = HOME.loadIntentOrNull()


}