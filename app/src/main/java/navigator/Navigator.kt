package navigator

import androidx.navigation.NavController

open class Navigator {
    lateinit var navController: NavController

    fun create(navController: NavController){
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
