package navigator.Hosts

import LoginScreen
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import data.database.AppDatabase
import data.repository.AppRepositoryProvider
import navigator.AppNavigator
import ui.components.BottomBar
import ui.screens.CarsScreen.CarsScreen
import ui.screens.CustomersListScreen.CustomersListScreen
import ui.screens.EmployeesListScreen.EmployeesListScreen
import ui.screens.Home.HomeScreen
import ui.screens.UserProfile.EmployeeProfileScreen

@Composable
fun AuthHost(){
    Scaffold(
        bottomBar = {
            BottomBar()
        }
    ) { padding ->
        NavHost(
            modifier = Modifier.fillMaxSize()
                .padding(bottom = padding.calculateBottomPadding() ),
            navController = AppNavigator.navController,
            startDestination = "login"
        ) {
            composable("login") {
                LoginScreen()
            }
        }
    }
}