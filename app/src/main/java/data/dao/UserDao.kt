package data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import data.entity.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao{
    @Upsert
    fun upsertUser(user: User)

    @Query(value = "SELECT * FROM Users ORDER BY id ASC")
    fun readAllData(): Flow<List<User>>

    @Query("SELECT * FROM Users WHERE id = :userId")
    fun getUserById(userId:Int) :Flow<User?>
}