package com.xvermilion.modulesample.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.xvermilion.modulesample.persistence.entites.UserEntity

@Dao
interface UserDao : BaseDao<UserEntity> {

    @Query("SELECT * FROM User LIMIT 1")
    suspend fun getUser(): UserEntity?

    @Query("SELECT * FROM User LIMIT 1")
    fun getUserLive(): LiveData<UserEntity?>

    @Query("SELECT COUNT(*) FROM User")
    suspend fun countUsers(): Int

    @Query("DELETE FROM User")
    suspend fun deleteAll()

}