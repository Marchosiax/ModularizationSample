package com.xvermilion.modulesample.persistence.entites

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.xvermilion.modulesample.library.dto.User

@Entity(tableName = "User")
data class UserEntity(
    @PrimaryKey
    override val id: Int,
    override var username: String?,
    override var password: String?
) : User