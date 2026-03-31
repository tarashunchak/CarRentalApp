package ui.screens.UserProfile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.carrentalapp.ui.theme.BackgroundBlue
import data.repository.AppRepositoryProvider
import ui.screens.UserProfile.Components.EmployeeOrders
import ui.screens.UserProfile.Components.MainInfo
import viewmodels.EmployeesViewModel
import viewmodels.EmployeesViewModelFactory

@Composable
fun EmployeeProfileScreen(employeeId:Int){
    val employeeRep = AppRepositoryProvider.employeesRepository
    val viewModel : EmployeesViewModel= viewModel(
        factory = EmployeesViewModelFactory(employeeRep)
    )
    val employee by viewModel.getEmployee(employeeId).collectAsState()
    Column(
        modifier = Modifier.fillMaxSize()
            .background(BackgroundBlue)
    ) {
        MainInfo(employee)
        EmployeeOrders(employeeId)
    }
}

@Composable
fun DataColumn(title:String?, text:String?){
    Column(){
        Spacer(
            modifier = Modifier.height(8.dp)
        )
        Text(
            text = title?:"",
            fontSize = 12.sp,
            color = Color.White,
        )
        Text(
            text = text?:"",
            fontSize = 18.sp,
            color = Color.White,
        )
        Spacer(
            modifier = Modifier.height(12.dp)
        )
    }
}

@Composable
fun DataRow(title:String?, text:String?){
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ){
        Spacer(
            modifier = Modifier.height(8.dp)
        )
        Text(
            text = title?:"",
            fontSize = 14.sp,
            color = Color.White,
        )
        Text(
            text = text?:"",
            fontSize = 18.sp,
            color = Color.White,
        )
        Spacer(
            modifier = Modifier.height(12.dp)
        )
    }
}