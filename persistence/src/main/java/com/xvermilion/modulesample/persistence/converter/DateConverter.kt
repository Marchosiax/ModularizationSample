package com.xvermilion.modulesample.persistence.converter

import androidx.room.TypeConverter
import java.util.*

object DateConverter {

    @JvmStatic
    @TypeConverter
    fun timeStampToDate(value: Long?) = value?.let { Date(it) }

    @JvmStatic
    @TypeConverter
    fun dateToTimeStamp(value: Date?) = value?.time

}