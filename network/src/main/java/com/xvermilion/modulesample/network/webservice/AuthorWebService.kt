package com.xvermilion.modulesample.network.webservice

import com.xvermilion.modulesample.network.model.AuthorResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AuthorWebService {

    @GET("Authors")
    suspend fun getAuthors(): Response<List<AuthorResponse>>

    @GET("Authors/{id}")
    suspend fun getAuthors(@Path("id") id: Int): Response<AuthorResponse>

}