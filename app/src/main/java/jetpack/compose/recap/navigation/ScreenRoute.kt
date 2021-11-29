package jetpack.compose.recap.navigation

const val ROOT_ROUTE = "default_route"

sealed class ScreenRoute(val route: String){
    object RootScreen : ScreenRoute(route = ROOT_ROUTE)
}
