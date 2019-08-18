package com.xvermilion.modulesample.network.webservice

import com.xvermilion.modulesample.network.model.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UserWebService {

    @GET("Users/{id}")
    suspend fun getUserInfo(@Path("id") id: Int): Response<UserResponse>

}