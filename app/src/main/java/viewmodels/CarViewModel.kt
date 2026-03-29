package viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import data.entity.Car
import data.repository.CarsRepository
import kotlinx.coroutines.launch

class CarViewModel(
    private val repository: CarsRepository
): ViewModel() {
    val cars = repository.cars

    fun insertCar(car: Car){
        viewModelScope.launch {
            repository.insertCar(car)
        }
    }

    fun updateCar(car: Car){
        viewModelScope.launch {
            repository.updateCar(car)
        }
    }
}

class CarViewModelFactory(
    private val repository: CarsRepository
): ViewModelProvider.Factory{
    override fun <T: ViewModel> create(modelClass: Class<T>):T{
        return CarViewModel(repository) as T
    }
}