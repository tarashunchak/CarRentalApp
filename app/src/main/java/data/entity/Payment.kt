package data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity
data class Payment (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val paymentType:String,
    val finalPrice:Float,
    val paymentDate: Date,
)