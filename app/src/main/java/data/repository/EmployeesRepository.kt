package data.repository

import data.dao.EmployeeDao
import data.entity.Employee

class EmployeesRepository (
    private val employeesDao: EmployeeDao
){
    val employees = employeesDao.readAllData()

    suspend fun insertEmployee(empl: Employee) = employeesDao.upsertEmployee(empl)
    suspend fun updateEmployee(empl: Employee) = employeesDao.upsertEmployee(empl)
    suspend fun getEmployee(emplId:Int) = employeesDao.getEmployeeById(emplId)
}