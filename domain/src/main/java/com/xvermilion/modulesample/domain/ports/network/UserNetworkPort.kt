package com.xvermilion.modulesample.domain.ports.network

import com.xvermilion.modulesample.library.NetworkResponse
import com.xvermilion.modulesample.library.dto.User

interface UserNetworkPort {

    suspend fun getUserInfo(id: Int): NetworkResponse<User>

}