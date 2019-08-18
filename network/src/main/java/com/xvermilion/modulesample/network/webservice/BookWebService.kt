package com.xvermilion.modulesample.network.webservice

import com.xvermilion.modulesample.network.model.BookResponse
import com.xvermilion.modulesample.network.model.CoverPhotoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BookWebService {

    @GET("Books")
    suspend fun getBooks(): Response<List<BookResponse>>

    @GET("Books/{id}")
    suspend fun getBook(@Path("id") id: Int): Response<BookResponse>

    @GET("books/covers/{bookId}")
    suspend fun getCoverPhoto(@Path("bookId") bookId: Int): Response<CoverPhotoResponse>

}