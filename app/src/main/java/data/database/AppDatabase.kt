package data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import data.dao.CarDao
import data.dao.CustomersDao
import data.dao.EmployeeDao
import data.dao.OrderDao
import data.dao.UserDao
import data.dao.WorkTypeDao
import data.entity.Car
import data.entity.Customers
import data.entity.Employees
import data.entity.Order
import data.entity.Payment
import data.entity.Producer
import data.entity.User
import data.entity.WorkType

@Database(
    entities = [
        Car::class,
        User::class,
        Producer::class,
        Customers::class,
        Payment::class,
        Employees::class,
        WorkType::class,
        Order::class],
    version=1,
)
abstract class AppDatabase : RoomDatabase(){
    abstract fun userDao(): UserDao
    abstract fun carDao(): CarDao
    abstract fun employeesDao(): EmployeeDao
    abstract fun customersDao (): CustomersDao
    abstract fun workTypeDao(): WorkTypeDao
    abstract fun ordersDao(): OrderDao
}