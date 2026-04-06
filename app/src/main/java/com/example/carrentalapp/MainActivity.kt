package com.example.carrentalapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import data.database.AppDatabase
import data.repository.AppRepositoryProvider
import navigator.AppNavigator
import navigator.Hosts.AppNavHost
import navigator.Hosts.AuthHost
import storage.SessionManager
import viewmodels.AuthViewModel
import viewmodels.AuthViewModelFactory
import viewmodels.EmployeesViewModel
import viewmodels.EmployeesViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        SessionManager.init(this)

        val db = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "rentCars.db"
        )
            .createFromAsset("rentCars.db")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()

        AppRepositoryProvider.init(db)

        setContent {
            MyNavigation()
        }
    }
}

@Composable
fun MyNavigation(){
    val navController = rememberNavController()
    AppNavigator.create(navController)
    val viewModel: AuthViewModel= viewModel(
        factory = AuthViewModelFactory(AppRepositoryProvider.usersRepository)
    )

    val isLoggedIn by SessionManager.isLoggedIn().collectAsState(false)
    Crossfade(targetState = isLoggedIn, label="RootRegistration") {
        loggedIn ->
        if(loggedIn){
            AppNavHost()
        }else{
            AuthHost()
        }
    }
}

