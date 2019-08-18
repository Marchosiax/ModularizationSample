package com.xvermilion.modulesample.network.adapter

import com.xvermilion.modulesample.domain.ports.network.AuthorNetworkPort
import com.xvermilion.modulesample.library.dto.Author
import com.xvermilion.modulesample.library.response
import com.xvermilion.modulesample.network.ErrorConverter
import com.xvermilion.modulesample.network.handleResponse
import com.xvermilion.modulesample.network.webservice.AuthorWebService

internal class AuthorNetworkAdapter(
    private val webService: AuthorWebService,
    private val errorConverter: ErrorConverter
) : AuthorNetworkPort {

    override suspend fun getAuthors() = response<List<Author>> {
        webService.getAuthors().handleResponse(errorConverter, this) { succeeded(it) }
    }

    override suspend fun getAuthor(id: Int) = response<Author> {
        webService.getAuthors(id).handleResponse(errorConverter, this) { succeeded(it) }
    }
}