package data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Work_type")
data class WorkType(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo("work_type_name")
    val workTypeName:String,
)
