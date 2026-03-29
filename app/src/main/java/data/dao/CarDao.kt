package data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import data.entity.Car
import kotlinx.coroutines.flow.Flow

@Dao
interface CarDao {
    @Upsert
    suspend fun upsertCar(car: Car)

    @Query( "SELECT * FROM cars ORDER BY id ASC")
    fun readAllData(): Flow<List<Car>>


    @Query("SELECT * FROM cars ORDER BY model ASC")
    fun getCarsOrderedByModel(): LiveData<List<Car>>

    @Query("SELECT * FROM cars ORDER BY daily_price ASC")
    fun getCarsOrderedByDailyPrice(): LiveData<List<Car>>
}