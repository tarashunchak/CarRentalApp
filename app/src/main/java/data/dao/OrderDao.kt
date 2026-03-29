package data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import data.entity.Order

@Dao
interface OrderDao {
    @Upsert
    fun usertOrder(order: Order)

    @Query(value = "SELECT * FROM orders ORDER BY id ASC")
    fun readAllData(): LiveData<List<Order>>
}