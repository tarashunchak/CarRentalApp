package data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "Cars",
    foreignKeys = [
        androidx.room.ForeignKey(
            entity = Producer::class,
            parentColumns = ["id"],
            childColumns = ["producer_id"],
            onDelete = androidx.room.ForeignKey.NO_ACTION,
        )
    ]
)
data class Car(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 1,
    val model: String = "",
    @ColumnInfo("producer_id")
    val producerId: Int = 0,
    val color: String = "",
    @ColumnInfo("release_date")
    val releaseDate:String? = null,
    @ColumnInfo("fuel_type")
    val fuelType: String = "",
    @ColumnInfo("num_of_seats")
    val numOfSeats: Int = 0,
    @ColumnInfo("daily_price", defaultValue = "0")
    val dailyPrice: Int = 0,
    @ColumnInfo("car_type")
    val carType:String = "",
    @ColumnInfo("serial_num")
    val serialNum:String,
    @ColumnInfo("status", defaultValue = "'Available'")
    val status:String = "Available",
    val price: Double? = null,
    val photo: ByteArray? = null,
)