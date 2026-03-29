package data.repository

import androidx.room.Database
import data.dao.UserDao
import data.entity.Car

@Database(
    entities = [Car::class],
    version = 1
)

class UserRepository (
    private val userDao: UserDao
){
}