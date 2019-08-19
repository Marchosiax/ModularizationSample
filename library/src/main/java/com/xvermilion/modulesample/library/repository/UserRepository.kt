package com.xvermilion.modulesample.library.repository

import com.xvermilion.modulesample.library.NetworkResponse
import com.xvermilion.modulesample.library.dto.User

interface UserRepository {

    suspend fun insertOrUpdateUserInfo(id: Int): NetworkResponse<User>

}