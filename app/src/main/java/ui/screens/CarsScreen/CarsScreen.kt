package ui.screens.CarsScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.carrentalapp.ui.theme.BackgroundBlue
import data.repository.AppRepositoryProvider
import ui.screens.Home.Components.CarCard
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
    Column(){
        Header()
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier.fillMaxSize()
                .background(BackgroundBlue)
                .padding(horizontal = 8.dp)
        ){
            items(cars){ car->
                CarCard(car)
            }
        }
    }
}
