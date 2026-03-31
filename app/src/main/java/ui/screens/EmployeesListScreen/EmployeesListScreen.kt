package ui.screens.EmployeesListScreen

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
import data.repository.AppRepositoryProvider
import ui.screens.EmployeesListScreen.Components.EmployeeCard
import ui.screens.Home.Components.Header
import viewmodels.EmployeesViewModel
import viewmodels.EmployeesViewModelFactory

@Composable
fun EmployeesListScreen(){
    val employeesRep = AppRepositoryProvider.employeesRepository
    val workTypeRep = AppRepositoryProvider.workTypeRepository
    val viewModel: EmployeesViewModel = viewModel(
        factory = EmployeesViewModelFactory(employeesRep)
    )
    val employees = viewModel.employees.collectAsState(emptyList())
    Column() {
        Header()
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .height(LocalConfiguration.current.screenHeightDp.dp)
                .fillMaxWidth()
                .background(Color(0xFF000A31))
                .padding(horizontal = 10.dp)
        ) {
            items(employees.value) { employee->
                EmployeeCard(employee, workTypeRep)
            }
        }
    }}