package data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Producer")
data class Producer(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    @ColumnInfo(name="producer_name")
    val producerName:String,
    val country:String,
)
