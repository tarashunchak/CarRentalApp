package com.example.carrentalapp

import LoginScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import data.database.AppDatabase
import data.repository.CarsRepository
import data.repository.EmployeesRepository
import navigator.AppNavigator
import navigator.Navigator
import ui.screens.Home.HomeScreen
import ui.screens.CarsScreen.CarsScreen
import ui.screens.UserProfile.EmployeeProfileScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val db = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "rentCars.db"
        )
            .createFromAsset("rentCars.db")
            .fallbackToDestructiveMigration()
            .build()
        setContent {
            MyNavigation(db)
        }
    }
}

@Composable
fun MyNavigation(db: AppDatabase){
    val navController = rememberNavController()
    AppNavigator.create(navController)
    val carsRepository = CarsRepository(db.carDao())
    val employeesRepository = EmployeesRepository(db.employeesDao())
    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navController,
        startDestination = "home"
    ){
        composable("home"){
            HomeScreen()
        }
        composable("login"){
            LoginScreen()
        }
        composable("profile"){
            EmployeeProfileScreen(employeesRepository)
        }
        composable("cars"){
            CarsScreen( carsRepository)
        }
    }
}

