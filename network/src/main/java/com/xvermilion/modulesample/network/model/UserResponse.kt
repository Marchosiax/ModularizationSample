package com.xvermilion.modulesample.network.model

import com.google.gson.annotations.SerializedName
import com.xvermilion.modulesample.library.dto.User

data class UserResponse(
    @SerializedName("ID")
    override val id: Int,
    @SerializedName("UserName")
    override var username: String?,
    @SerializedName("PassWord")
    override var password: String?
) : User