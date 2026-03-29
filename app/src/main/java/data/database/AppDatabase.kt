package data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import data.dao.CarDao
import data.dao.UserDao
import data.entity.Car
import data.entity.Order
import data.entity.User
import storage.models.Producer

@Database(
    entities = [
        Car::class,
        User::class,
        Producer::class,
        Order::class],
    version=1,
)
abstract class AppDatabase : RoomDatabase(){
    abstract fun userDao(): UserDao
    abstract fun carDao(): CarDao
}