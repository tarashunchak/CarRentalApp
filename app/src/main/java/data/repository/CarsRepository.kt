package data.repository

import data.dao.CarDao
import data.entity.Car

class CarsRepository(
    private val carDao: CarDao
){
    val cars = carDao.readAllData()

    suspend fun insertCar(car: Car){
        carDao.upsertCar(car)
    }

    suspend fun updateCar(car: Car){
        carDao.upsertCar(car)
    }

    suspend fun deleteCar(carId:Int){
    }
}
