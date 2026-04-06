package ui.screens.UserProfile.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import data.repository.AppRepositoryProvider

@Composable
fun EmployeeOrders(employeeId:Int){
    val orders by remember(employeeId) {
        AppRepositoryProvider.ordersRepository
            .getOrdersByEmployeeId(employeeId)
    }.collectAsState(emptyList())
    Column(
        verticalArrangement = Arrangement.spacedBy(5.dp),
    ) {
        orders.forEach {
            OrderCard(it)
        }
    }
}