package com.xvermilion.modulesample.library.repository

import androidx.lifecycle.LiveData
import com.xvermilion.modulesample.library.dto.Book

interface BookRepository {

    suspend fun insert(book: Book)

    suspend fun getBooks(): List<Book>

    fun getBooksLive(): LiveData<out List<Book>?>

}