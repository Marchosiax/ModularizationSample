package com.xvermilion.modulesample.domain.repository

import com.xvermilion.modulesample.domain.ports.network.UserNetworkPort
import com.xvermilion.modulesample.domain.ports.persistence.UserDaoPort
import com.xvermilion.modulesample.library.NetworkResponse
import com.xvermilion.modulesample.library.dto.User
import com.xvermilion.modulesample.library.repository.UserRepository

internal class UserRepositoryAdapter(
    private val userDaoPort: UserDaoPort,
    private val network: UserNetworkPort
) : UserRepository {

    override suspend fun insertOrUpdateUserInfo(id: Int): NetworkResponse<User> {
        val response = network.getUserInfo(id)
        if (response.isSuccessful())
            response.data?.let { userDaoPort.insertOrUpdate(it) }
        return response
    }

}