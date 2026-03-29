package data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity(tableName = "Payment")
data class Payment (
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    @ColumnInfo("payment_type")
    val paymentType:String,
    @ColumnInfo("final_price")
    val finalPrice:Double,
    @ColumnInfo("payment_date")
    val paymentDate: String? = null,
)