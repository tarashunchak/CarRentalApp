package ui.screens.CustomersListScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import data.repository.CustomersRepository
import ui.components.BottomBar
import ui.screens.CustomersListScreen.Components.CustomerCard
import ui.screens.Home.Components.Header
import viewmodels.CustomersViewModel
import viewmodels.CustomersViewModelFactory

@Composable
fun CustomersListScreen(repository: CustomersRepository){
    val viewModel: CustomersViewModel = viewModel(
        factory = CustomersViewModelFactory(repository)
    )
    val customers = viewModel.customers.collectAsState(initial = emptyList())
    Column() {
        Header()
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .height(LocalConfiguration.current.screenHeightDp.dp - 30.dp)
                .fillMaxWidth()
                .background(Color(0xFF000A31))
                .padding(10.dp)
        ) {
            items(customers.value) { customer ->
                CustomerCard(customer)
            }
        }
    }
}