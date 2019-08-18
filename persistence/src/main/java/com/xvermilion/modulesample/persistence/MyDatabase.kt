package com.xvermilion.modulesample.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.xvermilion.modulesample.persistence.converter.DateConverter
import com.xvermilion.modulesample.persistence.dao.UserDao
import com.xvermilion.modulesample.persistence.entites.BookEntity
import com.xvermilion.modulesample.persistence.entites.UserEntity

object DatabaseMetaData {
    const val NAME = "library.db"
    const val VERSION = 1
}

@TypeConverters(DateConverter::class)
@Database(entities = [UserEntity::class, BookEntity::class], version = DatabaseMetaData.VERSION)
abstract class MyDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

}