package data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import data.entity.Customers
import kotlinx.coroutines.flow.Flow

@Dao
interface CustomersDao {
    @Upsert()
    fun upsertCustomer(cust: Customers)

    @Query("SELECT * FROM Customers ORDER BY id ASC")
    fun getAllCustomers(): Flow<List<Customers>>

    @Query("SELECT * FROM Customers WHERE id = :custId")
    fun getCustomerById(custId: Int): Flow<Customers>
}