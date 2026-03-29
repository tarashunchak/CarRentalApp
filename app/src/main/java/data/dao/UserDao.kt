package data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import data.entity.User

@Dao
interface UserDao{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Query(value = "SELECT * FROM users ORDER BY id ASC")
    suspend fun readAllData(): LiveData<List<User>>

    @Update
    suspend fun updateUser()

    @Delete
    suspend fun deleteUser()
}