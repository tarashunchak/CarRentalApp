package ui.screens.Home.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carrentalapp.ui.theme.ForegroundBlue
import data.entity.Car
import services.LoadImageByByteArray

@Composable
fun CarCard(car: Car){
    Card (
        colors = CardDefaults.cardColors(containerColor = ForegroundBlue),
        modifier = Modifier.fillMaxWidth()
            .background(Color.Transparent)
            .height(260.dp)
            .clip(RoundedCornerShape(10))
    ) {
        LoadImageByByteArray(car.photo)
        Text(
            text = car.model,
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
        )
        Text(
            text = car.color,
            color = Color.White,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
        )
    }
}
