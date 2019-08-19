package com.xvermilion.modulesample.domain.ports.persistence

import androidx.lifecycle.LiveData
import com.xvermilion.modulesample.library.dto.Book

interface BookDaoPort {

    suspend fun insertOrReplace(book: Book)

    suspend fun getBooks(): List<Book>

    fun getBooksLive(): LiveData<out List<Book>?>

}