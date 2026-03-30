package ui.screens.CarsScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import data.repository.AppRepositoryProvider
import data.repository.CarsRepository
import ui.components.BottomBar
import ui.screens.Home.Components.ContentBlock
import ui.screens.Home.Components.Header
import viewmodels.CarViewModel
import viewmodels.CarViewModelFactory

@Composable
fun CarsScreen(){
    val carsRep = AppRepositoryProvider.carsRepository
    val viewModel : CarViewModel = viewModel(
        factory = CarViewModelFactory(carsRep)
    )
    val cars by viewModel.cars.collectAsState(initial = emptyList())
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
    ){
        Header()
        ContentBlock(cars)
    }
}
