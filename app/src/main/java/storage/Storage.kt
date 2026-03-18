package storage

import storage.models.Car
import storage.models.CreateCar
import storage.models.CreateProducer
import storage.models.CreateUser
import storage.models.Producer
import storage.models.User
import storage.models.UserProfile
import java.util.Date

public var users =  mutableMapOf<UInt, User>()
public var usersProfiles = mutableMapOf<UInt, UserProfile>()

public var producers = mutableMapOf<UInt, Producer>()
public var cars = mutableMapOf<UInt, Car>()

public fun FillWithTestData(){
    CreateUser(User("admin", "admin"))
    CreateProducer(Producer("Mercedes", "Germany"))
    CreateCar(Car("Some Auto", "white", 1u))
    CreateCar(Car("Some Auto", "white", 1u))
}