package data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import data.entity.Order

@Dao
interface OrderDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addOrder(order: Order)

    @Query(value = "SELECT * FROM orders ORDER BY id ASC")
    fun readAllData(): LiveData<List<Order>>
}