package ui.screens.UserProfile.Components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.carrentalapp.ui.theme.ForegroundBlue
import data.entity.Order
import ui.screens.EmployeesListScreen.Components.DataColumn
import ui.screens.UserProfile.DataRow

@Composable
fun OrderCard(order: Order){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(8.dp)
            .clickable(
                enabled = true,
                onClick = {}
            ),
        colors = CardDefaults.cardColors(containerColor = ForegroundBlue),
        shape = RoundedCornerShape(6.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        DataRow("ID", "${order.id}")
        DataRow("Car", "${order.carId}")
    }
}