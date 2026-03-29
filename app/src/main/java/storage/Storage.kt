package storage

import storage.models.Car
import storage.models.CreateCar
import storage.models.CreateProducer
import storage.models.CreateUser
import storage.models.Producer
import storage.models.User
import storage.models.UserProfile
import java.util.Date

private var currentUserID:UInt =  0u
public fun setCurrentUserID(id:UInt){
    currentUserID = id
}

public fun getCurrentUserID(): UInt{
    return currentUserID
}

public var users =  mutableMapOf<UInt, User>()
public var usersProfiles = mutableMapOf<UInt, UserProfile>()

public var producers = mutableMapOf<UInt, Producer>()
public var cars = mutableMapOf<UInt, Car>()

public fun FillWithTestData(){
    CreateUser(User("admin", "admin"))
    CreateProducer(Producer("Toyota", "Japan"))
    CreateProducer(Producer("BMW", "Germany"))
    CreateProducer(Producer("Tesla", "USA"))
    CreateProducer(Producer("Hyundai", "South Korea"))
    CreateProducer(Producer("Volvo", "Sweden"))
    CreateProducer(Producer("Ferrari", "Italy"))
    CreateProducer(Producer("Mercedes", "Germany"))
    CreateCar(Car("Toyota Camry", "white", 1u))
    CreateCar(Car("Honda Civic", "black", 2u))
    CreateCar(Car("Tesla Model 3", "red", 3u))
    CreateCar(Car("BMW M5", "blue", 4u))
    CreateCar(Car("Audi A6", "silver", 5u))
    CreateCar(Car("Mercedes-Benz E-Class", "dark_gray", 6u))
    CreateCar(Car("Porsche 911", "yellow", 7u))
    CreateCar(Car("Volkswagen Golf", "white", 8u))
    CreateCar(Car("Ford Mustang", "orange", 9u))
    CreateCar(Car("Hyundai Tucson", "brown", 10u))
    CreateCar(Car("Kia Sportage", "white", 11u))
    CreateCar(Car("Mazda CX-5", "red", 12u))
    CreateCar(Car("Volvo XC90", "black", 13u))
    CreateCar(Car("Lexus RX", "pearl", 14u))
    CreateCar(Car("Nissan Leaf", "green", 15u))
}