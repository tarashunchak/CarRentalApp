package data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val username:String,
    @ColumnInfo(name="password_hash")
    val passwordHash:String = "undefined",
)