package com.xvermilion.modulesample.network.adapter

import com.xvermilion.modulesample.domain.ports.network.UserNetworkPort
import com.xvermilion.modulesample.library.dto.User
import com.xvermilion.modulesample.library.response
import com.xvermilion.modulesample.network.ErrorConverter
import com.xvermilion.modulesample.network.handleResponse
import com.xvermilion.modulesample.network.webservice.UserWebService

internal class UserNetworkAdapter(
    private val webservice: UserWebService,
    private val errorConverter: ErrorConverter
) : UserNetworkPort {

    override suspend fun getUserInfo(id: Int) = response<User> {
        webservice.getUserInfo(id).handleResponse(errorConverter, this) { succeeded(it) }
    }
}