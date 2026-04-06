package ui.screens.UserProfile.Components

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.entity.Employees
import services.LoadImageByUrl
import ui.components.ReturnButton
import ui.screens.UserProfile.DataColumn
import ui.screens.UserProfile.DataRow

@Composable
fun MainInfo(employee: Employees?) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF2D2D2D)),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ){
                ReturnButton(null)
                LogOutButton()
            }
            Text(
                text = "Employee Profile",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFE3E3E3),
                letterSpacing = 0.5.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Surface(
                    modifier = Modifier
                        .weight(0.4f)
                        .fillMaxHeight(),
                    shape = RoundedCornerShape(16.dp),
                    color = Color.White.copy(alpha = 0.1f),
                    border = BorderStroke(1.dp, Color.White)
                ) {
                    LoadImageByUrl()
                }

                Column(
                    modifier = Modifier.weight(0.6f),
                    verticalArrangement = Arrangement.Center
                ) {
                    InfoBadge(label = "ID", value = "#${employee?.id ?: "---"}")
                    Spacer(modifier = Modifier.height(8.dp))
                    InfoBadge(label = "Born", value = employee?.dateOfB ?: "Unknown")
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
            Divider(color = Color.White.copy(alpha = 0.1f), thickness = 1.dp)
            Spacer(modifier = Modifier.height(16.dp))

            // Основні дані
            DetailRow(label = "Full Name", value = employee?.fullName, icon = Icons.Default.Person)
            DetailRow(label = "Email Address", value = employee?.email, icon = Icons.Default.Email)
            DetailRow(label = "Location", value = employee?.address, icon = Icons.Default.LocationOn)
        }
    }
}

@Composable
fun InfoBadge(label: String, value: String) {
    Column {
        Text(label, color = Color.Gray, style = MaterialTheme.typography.labelMedium)
        Text(value, color = Color.White, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Medium)
    }
}

@Composable
fun DetailRow(label: String, value: String?, icon: ImageVector) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFFBB86FC), // Акцентний колір
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(text = label, color = Color.Gray, style = MaterialTheme.typography.labelSmall)
            Text(
                text = value ?: "Not specified",
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
@Composable
fun MainInfoo(employee: Employees?){
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
                LoadImageByUrl()
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