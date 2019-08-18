package com.xvermilion.modulesample.persistence.preferences

import android.content.SharedPreferences
import androidx.annotation.WorkerThread
import androidx.core.content.edit
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class BooleanPreference(
    private val preferences: SharedPreferences,
    private val name: String,
    private val defaultValue: Boolean
) : ReadWriteProperty<Any, Boolean> {

    @WorkerThread
    override fun getValue(thisRef: Any, property: KProperty<*>): Boolean =
        preferences.getBoolean(name, defaultValue)

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Boolean) =
        preferences.edit(true) { putBoolean(name, value) }

}

class LongPreference(
    private val preferences: SharedPreferences,
    private val name: String,
    private val defaultValue: Long
) : ReadWriteProperty<Any, Long> {

    @WorkerThread
    override fun getValue(thisRef: Any, property: KProperty<*>): Long =
        preferences.getLong(name, defaultValue)

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Long) =
        preferences.edit(true) { putLong(name, value) }

}

class StringPreference(
    private val preferences: SharedPreferences,
    private val name: String,
    private val defaultValue: String?
) : ReadWriteProperty<Any, String?> {

    @WorkerThread
    override fun getValue(thisRef: Any, property: KProperty<*>): String? =
        preferences.getString(name, defaultValue)

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String?) =
        preferences.edit(true) { putString(name, value) }
}

class StringSetPreference(
    private val preferences: SharedPreferences,
    private val name: String,
    private val defaultValue: MutableSet<String>?
) : ReadWriteProperty<Any, MutableSet<String>?> {

    @WorkerThread
    override fun getValue(thisRef: Any, property: KProperty<*>): MutableSet<String>? =
        preferences.getStringSet(name, defaultValue)

    override fun setValue(thisRef: Any, property: KProperty<*>, value: MutableSet<String>?) =
        preferences.edit(true) { putStringSet(name, value) }


}
