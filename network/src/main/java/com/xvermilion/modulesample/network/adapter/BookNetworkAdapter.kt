package com.xvermilion.modulesample.network.adapter

import com.xvermilion.modulesample.domain.ports.network.BookNetworkPort
import com.xvermilion.modulesample.library.dto.Book
import com.xvermilion.modulesample.library.dto.Cover
import com.xvermilion.modulesample.library.response
import com.xvermilion.modulesample.network.ErrorConverter
import com.xvermilion.modulesample.network.handleResponse
import com.xvermilion.modulesample.network.webservice.BookWebService

internal class BookNetworkAdapter(
    private val webService: BookWebService,
    private val errorConverter: ErrorConverter
) : BookNetworkPort {

    override suspend fun getBooks() = response<List<Book>> {
        webService.getBooks().handleResponse(errorConverter, this) { succeeded(it) }
    }

    override suspend fun getBook(id: Int) = response<Book> {
        webService.getBook(id).handleResponse(errorConverter, this) { succeeded(it) }
    }

    override suspend fun getCoverPhoto(bookId: Int) = response<Cover> {
        webService.getCoverPhoto(bookId).handleResponse(errorConverter, this) { succeeded(it) }
    }
}