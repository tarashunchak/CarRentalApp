package data.entity

import androidx.room.ForeignKey
import androidx.room.PrimaryKey

data class Car(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val model: String,
    val releaseDate: String,
    val producerId: Int,
    val photo:String,
    val color: String,
    val fuelType:String,
    val numOfSeats: Int,
    val dailyPrice: Float,
)
