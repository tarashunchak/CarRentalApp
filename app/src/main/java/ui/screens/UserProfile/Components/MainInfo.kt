package ui.screens.UserProfile.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carrentalapp.ui.theme.ForegroundBlue
import data.entity.Employees
import ui.screens.UserProfile.DataColumn
import ui.screens.UserProfile.DataRow

@Composable
fun MainInfo(employee: Employees?){
    Column(
        modifier = Modifier
            .background(Color(0xFF3A3A3A))
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
                DataRow("Date of B: ", employee?.dateOfB)
            }
        }
        DataColumn("Full Name: ", employee?.fullName)
        DataColumn("Address: ", employee?.address)
        DataColumn("Email: ", employee?.email)
    }
}