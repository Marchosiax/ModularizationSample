package com.xvermilion.modulesample.network.model

import com.google.gson.annotations.SerializedName
import com.xvermilion.modulesample.library.dto.Book

data class BookResponse(
    @SerializedName("ID")
    override val id: Int,
    @SerializedName("Title")
    override val title: String?,
    @SerializedName("Description")
    override val description: String?,
    @SerializedName("PublishDate")
    override val publishDate: String?,
    @SerializedName("PageCount")
    override val pages: Int
) : Book