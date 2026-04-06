package navigator

import androidx.navigation.NavHostController

open class Navigator {
    lateinit var navController: NavHostController

    fun create(navController: NavHostController){
        this.navController = navController
    }

    fun navigate(route:String){
        navController.navigate(route)
    }

    fun popBack(){
        navController.popBackStack()
    }

    fun clear(){
        this.navController.clearBackStack<Any>()
    }
}

object AppNavigator: Navigator()
