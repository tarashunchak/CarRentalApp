package ui.screens.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import ui.screens.Home.Components.Header
import ui.screens.Home.Components.OrdersChart

@Composable
fun HomeScreen(){
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF000A31))
    ){
        Header()
        OrdersChart()
    }
}