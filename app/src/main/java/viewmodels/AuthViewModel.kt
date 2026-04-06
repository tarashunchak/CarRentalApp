package viewmodels

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import data.repository.CustomersRepository
import data.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import storage.SessionManager
import java.security.MessageDigest

class AuthViewModel (
    private val repository: UserRepository
): ViewModel(){
    private val _isLoggedIn = MutableStateFlow(true)
    val isLoggedIn = _isLoggedIn.asStateFlow()

    fun login(username: String, password:String){
        viewModelScope.launch {
            val dbUser = repository.getUserByUsername(username).firstOrNull()
            val inputHash = StringToSha256(password)
            if(dbUser != null && dbUser.passwordHash.toString() == inputHash.toString())
                SessionManager.saveSession(dbUser.id)
            else _isLoggedIn.value = false
        }
    }
}

class AuthViewModelFactory(
    private val repository: UserRepository
): ViewModelProvider.Factory{
    override fun <T: ViewModel> create(modelClass: Class<T>):T{
        return AuthViewModel(repository) as T
    }
}

fun StringToSha256(str: String): ByteArray{
    val bytes = MessageDigest.getInstance("SHA-256").digest(str.toByteArray())
    return bytes
}