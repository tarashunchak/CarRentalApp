package storage.models

import storage.cars
import storage.users

/*------------------Order-------------------*/
private var _orderAI = 0u;
data class Order(
    val carID:UInt,
    val userID:UInt,
    val country:String,
    val id:UInt = _orderAI++,
)

fun CreateOrder(order: Order){
    if(!cars.contains(order.carID))
        throw Exception("Car with id ${order.carID} not exist")
    else if(!users.contains(order.userID))
        throw Exception("User with id ${order.userID} not exist")
}