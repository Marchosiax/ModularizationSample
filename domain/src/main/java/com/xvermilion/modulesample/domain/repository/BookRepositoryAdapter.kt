package com.xvermilion.modulesample.domain.repository

import com.xvermilion.modulesample.domain.ports.network.BookNetworkPort
import com.xvermilion.modulesample.domain.ports.persistence.BookDaoPort
import com.xvermilion.modulesample.library.NetworkResponse
import com.xvermilion.modulesample.library.dto.Book
import com.xvermilion.modulesample.library.repository.BookRepository

internal class BookRepositoryAdapter(
    private val bookDaoPort: BookDaoPort,
    private val network: BookNetworkPort
) : BookRepository {

    override suspend fun insertFavourite(book: Book) {
        bookDaoPort.insertOrReplace(book)
    }

    override suspend fun getFavouriteBooks() = bookDaoPort.getBooks()

    override fun getFavouriteBooksLive() = bookDaoPort.getBooksLive()

    override suspend fun getBooks(): NetworkResponse<List<Book>> {
        val bookResponse = network.getBooks()
        bookResponse.data?.let { books ->
            books.forEach {
                val coverResponse = network.getCoverPhoto(it.id)
                it.cover = coverResponse.data?.url
            }
        }
        return bookResponse
    }

    override suspend fun getBook(id: Int): NetworkResponse<Book> {
        val response = network.getBook(id)
        if (response.isSuccessful()) {
            response.data?.let {
                val coverResponse = network.getCoverPhoto(it.id)
                it.cover = coverResponse.data?.url
            }
        }
        return response
    }

}