package data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import data.entity.Employees
import kotlinx.coroutines.flow.Flow

@Dao
interface EmployeeDao {
    @Upsert
    fun upsertEmployee(empl: Employees)

    @Query("SELECT * FROM Employees ORDER BY id ASC")
    fun readAllData(): Flow<List<Employees>>

    @Query("SELECT * FROM Employees WHERE id = :emplId")
    fun getEmployeeById(emplId:Int): Flow<Employees>
}