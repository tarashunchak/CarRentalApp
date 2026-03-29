package data.repository

import data.dao.CarDao
import data.entity.Car

class CarsRepository(
    private val carDao: CarDao
){
    suspend fun addCar(car: Car){
        carDao.upsertCar(car)
    }

    suspend fun updateCar(car: Car){
        carDao.upsertCar(car)
    }

    suspend fun deleteCar(carId:Int){
        carDao.deleteCar()
    }
}
