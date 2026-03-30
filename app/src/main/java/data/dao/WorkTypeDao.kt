package data.dao

import androidx.room.Dao
import androidx.room.Query
import data.entity.WorkType
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkTypeDao {
    @Query("SELECT * FROM Work_type WHERE id = :workTypeId")
    fun getWorkTypeById(workTypeId: Int): Flow<WorkType>
}