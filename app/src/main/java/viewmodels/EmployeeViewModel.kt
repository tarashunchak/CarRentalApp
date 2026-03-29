package viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import data.entity.Employees
import data.repository.EmployeesRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class EmployeesViewModel(
    private val repository: EmployeesRepository
): ViewModel() {
    val employees = repository.employees

    fun insertCar(employee: Employees){
        viewModelScope.launch {
            repository.insertEmployee(employee)
        }
    }

    fun updateCar(employee: Employees){
        viewModelScope.launch {
            repository.updateEmployee(employee)
        }
    }

    fun getEmployee(emplId: Int): StateFlow<Employees?>{
        return repository.getEmployee(emplId).stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = null
        )
    }
}

class EmployeesViewModelFactory(
    private val repository: EmployeesRepository
): ViewModelProvider.Factory{
    override fun <T: ViewModel> create(modelClass: Class<T>):T{
        return EmployeesViewModel(repository) as T
    }
}