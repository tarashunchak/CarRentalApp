package ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
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
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.carrentalapp.ui.theme.ForegroundBlue
import navigator.AppNavigator

@Composable
fun BottomBarS(){
    var activeButton by remember { mutableStateOf("Home") }
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
            .height(60.dp)
            .background(ForegroundBlue)
            .zIndex(3f)
    ){
        BottomBarButton("Profile", {
            activeButton="Profile"
            AppNavigator.navigate("profile")
        }, activeButton=="Profile")
        BottomBarButton("Home", {
            activeButton="Home"
            AppNavigator.navigate("home")
        }, activeButton=="Home")
        BottomBarButton("Cars", {
            activeButton="Cars"
            AppNavigator.navigate("cars")
        }, activeButton=="Cars")
        BottomBarButton("Customers", {
            activeButton="Customers"
            AppNavigator.navigate("customers")
        }, activeButton=="Customers")
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

@Composable
fun BottomBar(){
    val navBackStackEntry: NavBackStackEntry? by AppNavigator.navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar() {
        NavigationBarItem(
            selected = currentRoute == "profile",
            onClick = { AppNavigator.navigate(("profile"))},
            icon = {Icon(Icons.Default.AccountCircle, contentDescription = null)},
            label={Text("Profile")},
        )
        NavigationBarItem(
            selected = currentRoute == "cars",
            onClick = { AppNavigator.navigate(("cars"))},
            icon = {Icon(Icons.Default.Build, contentDescription = null)},
            label={Text("Cars")},
        )
        NavigationBarItem(
            selected = currentRoute == "home",
            onClick = { AppNavigator.navigate(("home"))},
            icon = {Icon(Icons.Default.Home, contentDescription = null)},
            label={Text("Home")},
        )
        NavigationBarItem(
            selected = currentRoute == "employees",
            onClick = { AppNavigator.navigate(("employees"))},
            icon = {Icon(Icons.Default.List, contentDescription = null)},
            label={Text("Employees")},
        )
        NavigationBarItem(
            selected = currentRoute == "customers",
            onClick = { AppNavigator.navigate(("customers"))},
            icon = {Icon(Icons.Default.Person, contentDescription = null)},
            label={Text("Customers")},
        )
    }
}
