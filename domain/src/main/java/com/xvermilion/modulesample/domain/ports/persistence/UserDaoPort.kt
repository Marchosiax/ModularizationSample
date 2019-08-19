package com.xvermilion.modulesample.domain.ports.persistence

import androidx.lifecycle.LiveData
import com.xvermilion.modulesample.library.dto.User

interface UserDaoPort {

    suspend fun insertOrUpdate(user: User)

    suspend fun update(user: User)

    suspend fun getUser(): User?

    suspend fun getUserLive(): LiveData<out User?>

    suspend fun countUsers(): Int

    suspend fun deleteAll()

    suspend fun deleteUser()

}