package viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import data.entity.Customers
import data.repository.CustomersRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class CustomersViewModel(
    private val repository: CustomersRepository
): ViewModel() {
    val customers = repository.customers

    fun insertCar(customer: Customers){
        viewModelScope.launch {
            repository.insertCustomer(customer)
        }
    }

    fun updateCar(customer: Customers){
        viewModelScope.launch {
            repository.updateCustomer(customer)
        }
    }

    fun getCustomer(emplId: Int): StateFlow<Customers?>{
        return repository.getCustomer(emplId).stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = null
        )
    }
}

class CustomersViewModelFactory(
    private val repository: CustomersRepository
): ViewModelProvider.Factory{
    override fun <T: ViewModel> create(modelClass: Class<T>):T{
        return CustomersViewModel(repository) as T
    }
}