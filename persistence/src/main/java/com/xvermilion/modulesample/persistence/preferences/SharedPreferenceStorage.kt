package com.xvermilion.modulesample.persistence.preferences

import android.content.Context
import com.xvermilion.modulesample.domain.ports.persistence.PreferenceStorage

class SharedPreferenceStorage(context: Context) : PreferenceStorage {

    companion object {
        private const val PREFERENCES = "MySharedPreferences"
        private const val TEST = "Test"
    }

    private val prefs = context.applicationContext
        .getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)

    override var test: Boolean by BooleanPreference(prefs, TEST, false)

}