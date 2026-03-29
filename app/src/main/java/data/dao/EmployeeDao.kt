package data.dao

import androidx.room.Query
import androidx.room.Upsert
import data.entity.Employee

interface EmployeeDao {
    @Upsert
    fun upsertEmployee(empl: Employee)

    @Query("SELECT * FROM Employees ORDER BY id ASC")
    fun readAllData()

    @Query("SELECT * FROM Employees WHERE id = :emplId")
    fun getEmployeeById(emplId:Int)
}