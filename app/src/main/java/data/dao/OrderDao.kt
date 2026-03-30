package data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import data.entity.Order
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderDao {
    @Upsert
    fun usertOrder(order: Order)

    @Query(value = "SELECT * FROM orders ORDER BY id ASC")
    fun readAllData(): LiveData<List<Order>>

    @Query("SELECT * FROM Orders WHERE employee_id = :emplId")
    fun getOrdersByEmployeeId(emplId:Int): Flow<List<Order>>
}