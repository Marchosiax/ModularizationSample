package com.xvermilion.modulesample.library.repository

import androidx.lifecycle.LiveData
import com.xvermilion.modulesample.library.NetworkResponse
import com.xvermilion.modulesample.library.dto.Book

interface BookRepository {

    suspend fun insertFavourite(book: Book)

    suspend fun getFavouriteBooks(): List<Book>

    fun getFavouriteBooksLive(): LiveData<out List<Book>?>

    suspend fun getBooks(): NetworkResponse<List<Book>>

    suspend fun getBook(id: Int): NetworkResponse<Book>
}