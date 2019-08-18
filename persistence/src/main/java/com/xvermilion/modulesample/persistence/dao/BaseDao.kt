package com.xvermilion.modulesample.persistence.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface BaseDao<T> {

    @Insert
    suspend fun insert(item: T): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplace(item: T): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnore(item: T): Long

    @Insert
    suspend fun insertAll(items: List<T>): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllOrReplace(items: List<T>): List<Long>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllOrIgnore(items: List<T>): List<Long>

    @Update
    suspend fun update(item: T): Int

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateOrReplace(item: T): Int

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateOrIgnore(item: T): Int

    @Update
    suspend fun updateAll(items: List<T>): Int

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateAllOrReplace(items: List<T>): Int

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateAllOrIgnore(items: List<T>): Int

    @Delete
    suspend fun delete(item: T): Int

    @Delete
    suspend fun deleteAll(items: List<T>): Int

}