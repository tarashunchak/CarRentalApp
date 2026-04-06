package ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import navigator.AppNavigator

@Composable
fun ReturnButton(modifier: Modifier?){
    Box(
        Modifier
            .border(1.dp, Color(0x0AFFFFFF), CircleShape)
            .background(Color(0x05FFFFFF), CircleShape)
            .width(46.dp)
            .height(46.dp)
            .clickable(true, onClick = {
                AppNavigator.popBack()
            }),
    ){
        Icon(
            imageVector =  Icons.Default.ArrowBack,
            contentDescription = null,
            tint = Color(0xFFFFFFFF),
            modifier = Modifier.fillMaxSize(0.8f),
        )
    }
}