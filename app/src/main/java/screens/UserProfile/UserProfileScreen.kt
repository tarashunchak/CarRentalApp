package screens.UserProfile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import components.BottomBar

@Composable
fun UserProfileScreen(navController: NavController, userID: UInt=1u){
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color(0xFF000A31))
    ){
        BottomBar(navController)
    }
}