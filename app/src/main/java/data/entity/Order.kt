package data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Orders",
    foreignKeys = [

        ForeignKey(
            entity = Customers::class,
            parentColumns = ["id"],
            childColumns = ["cust_id"],
            onDelete = ForeignKey.NO_ACTION,
        ),
        ForeignKey(
            entity = Payment::class,
            parentColumns = ["id"],
            childColumns = ["payment_id"],
            onDelete = ForeignKey.NO_ACTION,
        ),
        ForeignKey(
            entity = Employee::class,
            parentColumns = ["id"],
            childColumns = ["employee_id"],
            onDelete = ForeignKey.NO_ACTION,
        ),
    ]
)
data class Order (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo("order_date")
    val orderDate: String,
    @ColumnInfo("car_id")
    val carId: Int,
    @ColumnInfo("payment_id")
    val paymentId: Int,
    @ColumnInfo("start_date")
    val startDate: String,
    @ColumnInfo("end_date")
    val endDate: String,
    @ColumnInfo("rent_term")
    val rentTerm: String,
    @ColumnInfo("employee_id")
    val employeeId: Int,
    @ColumnInfo("cust_id")
    val custId: Int,
    val status: String = "Active",
    @ColumnInfo("return_date")
    val returnDate: String? = null,
)