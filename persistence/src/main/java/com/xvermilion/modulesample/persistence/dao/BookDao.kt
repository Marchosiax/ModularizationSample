package com.xvermilion.modulesample.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.xvermilion.modulesample.library.dto.Book
import com.xvermilion.modulesample.persistence.entites.BookEntity

@Dao
interface BookDao : BaseDao<BookEntity> {

    @Query("SELECT * FROM Book")
    suspend fun getBooks(): List<Book>

    @Query("SELECT * FROM Book")
    fun getBooksLive(): LiveData<List<BookEntity>?>

}