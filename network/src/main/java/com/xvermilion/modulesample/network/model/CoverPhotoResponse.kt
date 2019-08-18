package com.xvermilion.modulesample.network.model

import com.google.gson.annotations.SerializedName
import com.xvermilion.modulesample.library.dto.Cover

data class CoverPhotoResponse(
    @SerializedName("ID")
    override val id: Int,
    @SerializedName("IDBook")
    override val bookId: Int,
    @SerializedName("Url")
    override val url: String?
) : Cover