package com.xvermilion.modulesample.domain.ports.network

import com.xvermilion.modulesample.library.NetworkResponse
import com.xvermilion.modulesample.library.dto.Author

interface AuthorNetworkPort {

    suspend fun getAuthors(): NetworkResponse<List<Author>>

    suspend fun getAuthor(id: Int): NetworkResponse<Author>

}