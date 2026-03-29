package ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.carrentalapp.ui.theme.ForegroundBlue

@Composable
fun BottomBar(navController: NavController){
    var activeButton by remember { mutableStateOf("Home") }
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
            .height(60.dp)
            .background(ForegroundBlue)
            .zIndex(2f)
    ){
        BottomBarButton("Profile", {
            activeButton="Profile"
            navController.navigate("profile")
        }, activeButton=="Profile")
        BottomBarButton("Home", {activeButton="Home"}, activeButton=="Home")
        BottomBarButton("Cars", {activeButton="Cars"}, activeButton=="Cars")
        BottomBarButton("Customers", {activeButton="Customers"}, activeButton=="Customers")
    }
}

@Composable
fun BottomBarButton(name:String, onClick:()->Unit, isActive:Boolean){
    val fontWeight = if(isActive)
        FontWeight.Bold
    else
        FontWeight.Normal

    val color = if(isActive)
        Color(0xFF0079FF)
    else
        Color.White
    Box(
        modifier = Modifier.clickable(
            interactionSource = remember{ MutableInteractionSource()},
            indication = null
        ){
            onClick()
        },
    ){
        Text(
            color = color,
            fontSize = 20.sp,
            fontWeight = fontWeight,
            text=name,
            textAlign = TextAlign.Center,
        )
    }
}