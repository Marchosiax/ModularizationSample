package com.xvermilion.modulesample.network.model

import com.google.gson.annotations.SerializedName
import com.xvermilion.modulesample.library.dto.Author

data class AuthorResponse(
    @SerializedName("ID")
    override val id: Int,
    @SerializedName("FirstName")
    override val firstName: String?,
    @SerializedName("LastName")
    override val lastName: String?
) : Author