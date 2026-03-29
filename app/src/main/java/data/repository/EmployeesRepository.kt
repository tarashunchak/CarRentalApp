package data.repository

import data.dao.EmployeeDao
import data.entity.Employees

class EmployeesRepository (
    private val employeesDao: EmployeeDao
){
    val employees = employeesDao.readAllData()
    fun insertEmployee(empl: Employees) = employeesDao.upsertEmployee(empl)
    fun updateEmployee(empl: Employees) = employeesDao.upsertEmployee(empl)
    fun getEmployee(emplId:Int) = employeesDao.getEmployeeById(emplId)
}