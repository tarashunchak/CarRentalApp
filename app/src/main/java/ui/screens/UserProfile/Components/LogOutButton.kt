package ui.screens.UserProfile.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import navigator.AppNavigator

@Composable
fun LogOutButton(){
    Box(
        Modifier
            .border(0.dp, Color(0x00000000), CircleShape)
            .background(Color.Transparent, CircleShape)
            .width(46.dp)
            .height(46.dp)
            .clickable(true, onClick = {
                AppNavigator.clear()
                AppNavigator.navigate("login")
            }),
    ){
        Icon(
            imageVector =  Icons.Default.ExitToApp,
            contentDescription = null,
            tint = Color(0xFFFFFFFF),
            modifier = Modifier.fillMaxSize(0.8f),
        )
    }
}