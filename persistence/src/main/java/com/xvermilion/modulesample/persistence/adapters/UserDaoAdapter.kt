package com.xvermilion.modulesample.persistence.adapters

import com.xvermilion.modulesample.domain.ports.persistence.UserDaoPort
import com.xvermilion.modulesample.library.dto.User
import com.xvermilion.modulesample.persistence.dao.UserDao
import com.xvermilion.modulesample.persistence.entites.UserEntity

data class UserDaoAdapter(
    private val userDao: UserDao
) : UserDaoPort {

    override suspend fun insert(user: User) {
        if (user is UserEntity)
            userDao.insert(user)
        else
            userDao.update(UserEntity(user.id, user.username, user.password))
    }

    override suspend fun update(user: User) {
        if (user is UserEntity)
            userDao.update(user)
        else
            userDao.update(UserEntity(user.id, user.username, user.password))
    }

    override suspend fun getUser() = userDao.getUser()

    override suspend fun getUserLive() = userDao.getUserLive()

    override suspend fun countUsers() = userDao.countUsers()

    override suspend fun deleteAll() = userDao.deleteAll()

    override suspend fun deleteUser() {
        getUser()?.let { userDao.delete(it) }
    }

}