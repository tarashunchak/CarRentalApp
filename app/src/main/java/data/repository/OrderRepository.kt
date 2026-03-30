package data.repository

import data.dao.OrderDao

class OrderRepository(
    private val orderRao: OrderDao
) {
    val orders = orderRao.readAllData()
    fun getOrdersByEmployeeId(emplId:Int) = orderRao.getOrdersByEmployeeId(emplId)
}