package com.xvermilion.modulesample.persistence.entites

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.xvermilion.modulesample.library.dto.Book

@Entity(tableName = "Book")
data class BookEntity(
    @PrimaryKey
    override val id: Int,
    override val title: String?,
    override val description: String?,
    override val publishDate: String?,
    override val pages: Int
) : Book