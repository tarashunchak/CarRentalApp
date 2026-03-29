package ui.screens.Home.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun CarCard(car: data.entity.Car){
    Column(
        modifier = Modifier.fillMaxWidth()
            .background(Color(0x0AFFFFFF))
            .height(260.dp)
            .border(
                width = 1.dp,
                color = Color(0x14FFFFFF),
                shape = AbsoluteCutCornerShape(
                    10f, 10f,
                    10f, 10f
            ),
        )
    ) {
        CarImage(car.photo)
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

@Composable
fun CarImage(photoByteArray: ByteArray?){
    AsyncImage(
        model = photoByteArray?: ImageRequest.Builder(LocalContext.current)
            .data("https://upload.wikimedia.org/wikipedia/commons/d/d6/Nophoto.jpg")
            .crossfade(true)
            .build(),
        contentDescription = "Car image",
        modifier = Modifier
            .border(
                width= 0.dp,
                color = Color(0x14FFFFFF),
                shape = AbsoluteCutCornerShape(
                    10f, 10f,
                ),
            )
            .fillMaxWidth()
            .height(180.dp)
        ,
        contentScale = ContentScale.Crop
    )
}