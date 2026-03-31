package services

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun LoadImageByUrl(
    url:String = "https://images.ctfassets.net/h6goo9gw1hh6/2sNZtFAWOdP1lmQ33VwRN3/24e953b920a9cd0ff2e1d587742a2472/1-intro-photo-final.jpg?w=1200&h=992&fl=progressive&q=70&fm=jpg"
){
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .crossfade(true)
            .build(),
        contentDescription = "Profile picture",
        modifier = Modifier
            .fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun LoadImageByByteArray(byteArray:ByteArray?){
    AsyncImage(
        model = byteArray ?: ImageRequest.Builder(LocalContext.current)
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