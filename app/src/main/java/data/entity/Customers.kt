package data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Customers")
data class Customers (
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    @ColumnInfo(name="full_name")
    val fullName: String,
    val phone: String,
    val email: String,
    @ColumnInfo(name="date_of_B")
    val dateOfB: String,
    @ColumnInfo(name="registration_date")
    val registrationDate: String,
)