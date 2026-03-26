package screens.Home

import components.BottomBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState
import screens.Home.Components.ContentBlock
import screens.Home.Components.Header
import storage.cars

@Composable
fun HomeScreen(){
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(LatLng(51.5074, -0.1278), 10f)
    }

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF000A31))
    ){
        Header()
        BottomBar(NavController(LocalContext.current))
    }
}