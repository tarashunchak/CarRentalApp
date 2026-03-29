package ui.screens.UserProfile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import data.repository.UserRepository
import ui.components.BottomBar
import viewmodels.UserViewModel
import viewmodels.UserViewModelFactory

@Composable
fun UserProfileScreen(navController: NavController, repository: UserRepository){
    val viewModel : UserViewModel = viewModel(
        factory = UserViewModelFactory(repository)
    )
    val user by viewModel.getUser(1).collectAsState()
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color(0xFF000A31))
    ){
        Text(user?.username?:"")
        BottomBar(navController)
    }
}