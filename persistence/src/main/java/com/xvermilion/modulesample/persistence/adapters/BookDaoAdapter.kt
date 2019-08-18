package com.xvermilion.modulesample.persistence.adapters

import com.xvermilion.modulesample.domain.ports.persistence.BookDaoPort
import com.xvermilion.modulesample.library.dto.Book
import com.xvermilion.modulesample.persistence.dao.BookDao
import com.xvermilion.modulesample.persistence.entites.BookEntity

internal class BookDaoAdapter(private val dao: BookDao) : BookDaoPort {

    override suspend fun insert(book: Book) {
        if (book is BookEntity)
            dao.insert(book)
        else
            dao.insert(
                BookEntity(
                    book.id,
                    book.title,
                    book.description,
                    book.publishDate,
                    book.pages
                )
            )
    }

    override suspend fun getBooks() = dao.getBooks()

    override fun getBooksLive() = dao.getBooksLive()
}