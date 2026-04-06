package data.repository

import data.dao.UserDao
import data.entity.User
import kotlinx.coroutines.flow.Flow

class UserRepository (
    private val userDao: UserDao
){
    val users = userDao.readAllData()

    suspend fun insertUser(user: User){
        userDao.upsertUser(user)
    }

    suspend fun updateUser(user: User){
        userDao.upsertUser(user)
    }

    suspend fun deleteCar(userId:Int){
    }

    fun getUserById(userId:Int) = userDao.getUserById(userId)
    fun getUserByUsername(username:String) = userDao.getUserByUsername(username)
}