package data.entity

import androidx.room.PrimaryKey

data class Order (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val orderDate:String,
    val carId:Int,
    val paymentId:Int,
    val startDate:String,
    val endDate:String,
    val custId:Int,
    val status:String,
    val returnDate:String,
)