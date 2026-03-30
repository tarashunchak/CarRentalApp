package data.repository

import data.dao.WorkTypeDao

class WorkTypeRepository(
    private val workTypeDao: WorkTypeDao
) {
    fun getWorkTypeById(workTypeId:Int) = workTypeDao.getWorkTypeById(workTypeId)
}