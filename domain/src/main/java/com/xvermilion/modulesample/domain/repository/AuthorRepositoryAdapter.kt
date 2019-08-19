package com.xvermilion.modulesample.domain.repository

import com.xvermilion.modulesample.domain.ports.network.AuthorNetworkPort
import com.xvermilion.modulesample.library.repository.AuthorRepository

internal class AuthorRepositoryAdapter(private val network: AuthorNetworkPort) : AuthorRepository {

    override suspend fun getAuthors() = network.getAuthors()

    override suspend fun getAuthor(id: Int) = network.getAuthor(id)

}