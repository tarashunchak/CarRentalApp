package viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import data.entity.User
import data.repository.UserRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class UserViewModel(
    private val repository: UserRepository
): ViewModel() {
    val users = repository.users

    fun insertCar(user: User){
        viewModelScope.launch {
            repository.insertUser(user)
        }
    }

    fun updateCar(user: User){
        viewModelScope.launch {
            repository.updateUser(user)
        }
    }

    fun getUser(userId: Int): StateFlow<User?>{
        return repository.getUserById(userId).stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = null
        )
    }
}

class UserViewModelFactory(
    private val repository: UserRepository
): ViewModelProvider.Factory{
    override fun <T: ViewModel> create(modelClass: Class<T>):T{
        return UserViewModel(repository) as T
    }
}