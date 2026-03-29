package data.dao

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import data.entity.Car

interface CarDao {
    @Upsert
    suspend fun upsertCar(car: Car)

    @Query( "SELECT * FROM cars ORDER BY id ASC")
    suspend fun readAllData(): LiveData<List<Car>>

    @Delete
    suspend fun deleteCar()

    @Query("SELECT * FROM cars ORDER BY model ASC")
    suspend fun getCarsOrderedByModel(): LiveData<List<Car>>

    @Query("SELECT * FROM cars ORDER BY daily_price ASC")
    suspend fun getCarsOrderedByDailyPrice(): LiveData<List<Car>>
}