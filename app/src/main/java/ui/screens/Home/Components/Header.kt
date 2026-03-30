package ui.screens.Home.Components

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import data.repository.EmployeesRepository
import storage.getCurrentUserID
import storage.users
import ui.screens.UserProfile.EmployeeProfileScreen
import viewmodels.UserViewModel

@Composable
fun Header(){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
            .height(100.dp)
            .background(Color(0xFF3A3A3A))
            .padding(10.dp)
    ){
        Box(
            modifier = Modifier.height(80.dp)
                .width(80.dp)
                .clip(CircleShape)
        ) {
            GetImageByUrl()
        }
        Spacer(modifier = Modifier.width(20.dp))
        Text(
            fontSize = 26.sp,
            color = Color.White,
            text = "",
        )
    }
}

@Composable
fun GetImageByUrl(
    url:String = "https://images.ctfassets.net/h6goo9gw1hh6/2sNZtFAWOdP1lmQ33VwRN3/24e953b920a9cd0ff2e1d587742a2472/1-intro-photo-final.jpg?w=1200&h=992&fl=progressive&q=70&fm=jpg"
){
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .crossfade(true)
            .build(),
        contentDescription = "Profile picture",
        modifier = Modifier
            .fillMaxWidth()
            .height(170.dp)
            .border(
                width= 0.dp,
                color = Color(0x14FFFFFF),
            ),
        contentScale = ContentScale.Crop
    )
}