package ui.screens.EmployeesListScreen.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carrentalapp.ui.theme.ForegroundBlue
import data.entity.Employees
import data.repository.WorkTypeRepository
import navigator.AppNavigator

@Composable
fun EmployeeCard(employee: Employees, repository: WorkTypeRepository){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 0.dp, vertical = 8.dp)
            .height(100.dp)
            .clickable(
                enabled = true,
                onClick = {
                    AppNavigator.navigate("profile/${employee.id}")
                }
            ),
        colors = CardDefaults.cardColors(containerColor = ForegroundBlue),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF0079FF)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = employee.fullName,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = "ID: ${employee.id}",
                    fontSize = 14.sp,
                    color = Color.White.copy(alpha = 0.7f)
                )
                Text(
                    text = employee.fullName,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = "${repository.getWorkTypeById(employee.workTypeId)}" ?: "Position not set",
                    fontSize = 14.sp,
                    color = Color.White.copy(alpha = 0.7f)
                )
            }
        }
    }
}

@Composable
fun DataColumn(title:String?, text:String?){
    Row(

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
            text?:"", fontSize = 18.sp,
            color = Color.White,
        )
        Spacer(
            modifier = Modifier.height(12.dp)
        )
    }
}
