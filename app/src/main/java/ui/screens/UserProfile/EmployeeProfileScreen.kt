package ui.screens.UserProfile

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.carrentalapp.ui.theme.BackgroundBlue
import com.example.carrentalapp.ui.theme.ForegroundBlue
import data.repository.AppRepositoryProvider
import data.repository.EmployeesRepository
import ui.components.BottomBar
import viewmodels.EmployeesViewModel
import viewmodels.EmployeesViewModelFactory

@Composable
fun EmployeeProfileScreen(){
    val employeeRep = AppRepositoryProvider.employeesRepository
    val viewModel : EmployeesViewModel= viewModel(
        factory = EmployeesViewModelFactory(employeeRep)
    )
    val employee by viewModel.getEmployee(1).collectAsState()
    val scrollState = rememberScrollState()
    val orders by remember(employee) {
        AppRepositoryProvider.ordersRepository.getOrdersByEmployeeId(employee?.id?:0)
    }.collectAsState(emptyList())
    LaunchedEffect(orders) {
        Log.d("EmployeeProfile", "Orders: ${orders.size}")
    }
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .height(LocalConfiguration.current.screenHeightDp.dp - 20.dp)
                .background(BackgroundBlue)
                .verticalScroll(scrollState)

        ) {
            Column(
                modifier = Modifier
                    .background(ForegroundBlue)
                    .fillMaxWidth()
                    .height(400.dp)
                    .padding(
                        horizontal = 10.dp,
                        vertical = 20.dp
                    )
            ) {
                Text(
                    fontSize = 24.sp,
                    text="Employee Info.",
                    color = Color.White,
                )
                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                        .height(200.dp)
                ){
                    Box(
                        modifier = Modifier.fillMaxHeight()
                            .fillMaxWidth(0.4f)
                            .background(Color.White)
                    ){

                    }
                    Column(
                        modifier = Modifier.fillMaxWidth(0.9f)
                    ){
                        DataRow("EID: ", "#${employee?.id}")
                        DataRow("Date of B: ", "${employee?.dateOfB}")
                    }
                }
                DataColumn("Full Name: ", employee?.fullName)
                DataColumn("Address: ", employee?.address)
                DataColumn("Email: ", employee?.email)
            }
        }
        Column(
            modifier = Modifier.fillMaxWidth()
                .height(300.dp)
        ) {
            orders.forEach { it ->
                Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
                    .background(Color.White)
                )
            }
        }
    }
}

@Composable
fun DataColumn(title:String?, text:String?){
    Column(

    ){
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