package com.xvermilion.modulesample.library.repository

import com.xvermilion.modulesample.library.NetworkResponse
import com.xvermilion.modulesample.library.dto.Author

interface AuthorRepository {

    suspend fun getAuthors(): NetworkResponse<List<Author>>

    suspend fun getAuthor(id: Int): NetworkResponse<Author>

}