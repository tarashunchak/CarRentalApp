package data.repository

import data.database.AppDatabase

object AppRepositoryProvider{
    lateinit var employeesRepository: EmployeesRepository
    lateinit var customersRepository: CustomersRepository
    lateinit var ordersRepository: OrderRepository
    lateinit var carsRepository: CarsRepository
    lateinit var workTypeRepository: WorkTypeRepository

    fun init(db: AppDatabase){
        carsRepository = CarsRepository(db.carDao())
        employeesRepository = EmployeesRepository(db.employeesDao())
        customersRepository = CustomersRepository(db.customersDao())
        workTypeRepository = WorkTypeRepository(db.workTypeDao())
        ordersRepository = OrderRepository(db.ordersDao())
    }
}