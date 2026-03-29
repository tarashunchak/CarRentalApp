package ui.screens.CarsScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import data.repository.CarsRepository
import ui.components.BottomBar
import ui.screens.Home.Components.ContentBlock
import viewmodels.CarViewModel
import viewmodels.CarViewModelFactory

@Composable
fun CarsScreen(navController: NavController, repository: CarsRepository){
    val viewModel : CarViewModel = viewModel(
        factory = CarViewModelFactory(repository)
    )
    val cars by viewModel.cars.collectAsState(initial = emptyList())
    ContentBlock(cars)
}