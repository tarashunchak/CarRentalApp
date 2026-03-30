package navigator

import androidx.navigation.NavController
import androidx.navigation.NavHostController

open class Navigator {
    lateinit var navController: NavHostController

    fun create(navController: NavHostController){
        this.navController = navController
    }

    fun navigate(route:String){
        navController?.navigate(route)
    }

    fun popBack(){
        navController?.popBackStack()
    }
}

object AppNavigator: Navigator()
