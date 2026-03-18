package screens.Home.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import storage.models.Car

@Composable
fun CarCard(car: Car){
    Column(
        modifier = Modifier.fillMaxWidth()
            .background(Color(0xFFFFFFFF))
            .height(60.dp)
    ){
        Text(
            text = car.model,
            color = Color.Black,
        )
    }
}