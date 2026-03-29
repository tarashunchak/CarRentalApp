package storage.models

import storage.cars
import storage.producers

/*------------------__producer-------------------*/
private var _producerAI = 0u;
data class __producer(
    val name:String,
    val country:String,
    val id:UInt = _producerAI++,
)

fun Create__producer(producer: __producer){
    producers.set(producer.id, producer)
}


/*------------------Car-------------------*/
private var _carAI = 0u;
data class Car(
    val model:String,
    val color:String,
    val producerID:UInt,
    val year:String = "2020",
    val imgUrl:String = "https://th.bing.com/th/id/OIP.riyTME1tYj6dUyk0nZRdTQHaE6?w=245&h=180&c=7&r=0&o=7&pid=1.7&rm=3",
    val carID:UInt = _carAI++,
)

fun CreateCar(car: Car){
    /*if(!producers.contains(car.producerID))
        throw Exception("__producer with id ${car.producerID} not exist")*/

    cars?.set(car.carID, car)
}