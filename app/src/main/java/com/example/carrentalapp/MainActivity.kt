package com.example.carrentalapp

import LoginScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import data.database.AppDatabase
import data.entity.Employee
import data.repository.CarsRepository
import data.repository.EmployeesRepository
import data.repository.UserRepository
import ui.screens.Home.HomeScreen
import ui.screens.UserProfile.UserProfileScreen
import ui.screens.CarsScreen.CarsScreen

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
    val carsRepository = CarsRepository(db.carDao())
    val employeesRepository = EmployeesRepository(db.employeeDao())
    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navController,
        startDestination = "profile"
    ){
        composable("home"){
            HomeScreen(navController)
        }
        composable("login"){
            LoginScreen(navController)
        }
        composable("profile"){
            UserProfileScreen(navController, usersRepository)
        }
        composable("cars"){
            CarsScreen(navController, carsRepository)
        }
    }
}

