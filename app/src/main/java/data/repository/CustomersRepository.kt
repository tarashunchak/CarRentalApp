package data.repository

import data.dao.CustomersDao
import data.entity.Customers

class CustomersRepository(
    private val customersDao: CustomersDao
){
    val customers = customersDao.getAllCustomers()
    fun insertCustomer(customer: Customers) =  customersDao.upsertCustomer(customer)
    fun updateCustomer(customer: Customers) =  customersDao.upsertCustomer(customer)
    fun getCustomer(customerId:Int) = customersDao.getCustomerById(customerId)
}