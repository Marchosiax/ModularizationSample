package com.xvermilion.modulesample.domain.ports.network

import com.xvermilion.modulesample.library.NetworkResponse
import com.xvermilion.modulesample.library.dto.Book
import com.xvermilion.modulesample.library.dto.Cover

interface BookNetworkPort {

    suspend fun getBooks(): NetworkResponse<List<Book>>

    suspend fun getBook(id: Int): NetworkResponse<Book>

    suspend fun getCoverPhoto(bookId: Int): NetworkResponse<Cover>

}