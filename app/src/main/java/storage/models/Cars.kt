package storage.models

import storage.cars
import storage.producers

/*------------------Producer-------------------*/
private var _producerAI = 0u;
data class Producer(
    val name:String,
    val country:String,
    val id:UInt = _producerAI++,
)

fun CreateProducer(producer: Producer){
    producers.set(producer.id, producer)
}


/*------------------Car-------------------*/
private var _carAI = 0u;
data class Car(
    val model:String,
    val color:String,
    val producerID:UInt,
    val carID:UInt = _carAI++,
)

fun CreateCar(car: Car){
    /*if(!producers.contains(car.producerID))
        throw Exception("Producer with id ${car.producerID} not exist")*/

    cars?.set(car.carID, car)
}