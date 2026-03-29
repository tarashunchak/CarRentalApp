package data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Customers (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val fullName:String,
    val phone:String,
    val email: String,
    val dateOfB:String,
    val registrationDate:String,
)