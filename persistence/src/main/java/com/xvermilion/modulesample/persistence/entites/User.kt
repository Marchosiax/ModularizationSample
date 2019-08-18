package com.xvermilion.modulesample.persistence.entites

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.xvermilion.modulesample.library.dto.User
import java.util.*

@Entity(tableName = "User")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    override var id: Long = -1,
    override var name: String?,
    override var username: String?,
    override var uuid: String?,
    override var serverToken: String?,
    override var serverUUID: String?,
    override var contract: String?,
    override var differTime: Long,
    override var clubScore: Long,
    override var clubCif: String?,
    override var clubEScore: Long,
    override var clubLevel: Int,
    override var clubRemainScore: Long,
    override var clubLastUpdate: Date?
) : User