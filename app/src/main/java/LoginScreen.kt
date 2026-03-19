import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import services.IsUserExist
import java.lang.ref.Reference

@Composable
fun LoginScreen(navController: NavController){
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color(0xFF000A31))
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text(
            text="Log In",
            fontSize = 46.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(60.dp))
        LoginTextField("Username", username)
        Spacer(modifier = Modifier.height(10.dp))
        LoginTextField("Password", password)
        Spacer(modifier = Modifier.height(20.dp))
        LoginButton({
            if(IsUserExist(username.value, password.value))
               navController.navigate("home"){
                   popUpTo(0)
               }
            else
                0
        })
    }
}

@Composable
fun LoginTextField(ph: String, state: MutableState<String>){
    TextField(
        modifier = Modifier.fillMaxWidth()
            .background(
                color = Color.White,
                shape = TextFieldDefaults.shape,
            ).clip(RoundedCornerShape(6.dp)),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
        ),
        value = state.value,
        onValueChange = {state.value = it},
        label={Text(ph)},
    )
}

@Composable
fun LoginButton(onClick:()-> Unit){
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(6.dp),
        modifier = Modifier.fillMaxWidth()
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(
            Color(0xFF0079FF),
            Color.White,
        )
    ){
        Text(
            text="Log In",
            fontSize = 20.sp,
        )
    }
}