package jetpack.compose.recap.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun RootNavGraph(
    navHostController: NavHostController
){
    NavHost(
        navController = navHostController,
        startDestination = ScreenRoute.RootScreen.route,
        route = ROOT_ROUTE
    ){
        composable(
            route = ScreenRoute.RootScreen.route
        ){
            DefaultScreen(navController = navHostController)
        }
    }
}