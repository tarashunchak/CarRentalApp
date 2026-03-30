package ui.screens.CustomersListScreen.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carrentalapp.ui.theme.ForegroundBlue
import data.entity.Customers

@Composable
fun CustomerCard(customer: Customers){
    Column(
        modifier = Modifier.fillMaxWidth()
            .height(80.dp)
            .background(ForegroundBlue)
    ) {
        DataColumn("ID: ",  "${customer.id}")
        DataColumn("Full Name: ",  customer.fullName)
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
