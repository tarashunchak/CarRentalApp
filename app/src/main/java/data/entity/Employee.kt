package data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Employees",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.NO_ACTION,
        ),
        ForeignKey(
            entity = WorkType::class,
            parentColumns = ["id"],
            childColumns = ["work_type_id"],
            onDelete = ForeignKey.NO_ACTION,
        )
    ]
)
data class Employee(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo("user_id")
    val userId:Int? = null,
    val phone:String,
    val email:String,
    @ColumnInfo("full_name")
    val fullName:String,
    @ColumnInfo(defaultValue = "0")
    val salary:Double,
    @ColumnInfo("date_of_B")
    val dateOfB:String,
    @ColumnInfo("work_type_id")
    val workTypeId:Int,
    val address:String? = null,
)
