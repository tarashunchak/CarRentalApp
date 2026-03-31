package ui.screens.UserProfile.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.repository.AppRepositoryProvider

@Composable
fun EmployeeOrders(employeeId:Int){
    val orders by remember(employeeId) {
        AppRepositoryProvider.ordersRepository
            .getOrdersByEmployeeId(employeeId)
    }.collectAsState(emptyList())
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.padding(horizontal = 5.dp)
    ) {
        items(orders){ order->
            OrderCard(order)
        }
    }
}