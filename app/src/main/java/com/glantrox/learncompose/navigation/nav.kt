package com.glantrox.learncompose.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.glantrox.learncompose.`interface`.DashboardScreenUI
import com.glantrox.learncompose.`interface`.EmployeeScreenUI
import com.glantrox.learncompose.`interface`.InterfaceDuaUI
import com.glantrox.learncompose.`interface`.InterfaceEnamUI
import com.glantrox.learncompose.`interface`.InterfaceLimaUI
import com.glantrox.learncompose.`interface`.InterfaceSatuUI
import com.glantrox.learncompose.`interface`.SplashScreenUI
import com.glantrox.learncompose.`interface`.auth.LoginScreenUI
import com.glantrox.learncompose.viewmodel.VideosViewModel


sealed class Screen(val route: String) {
    object splashScreen: Screen("splash_screen")
    object loginScreen: Screen("login_screen")
    object dashboardScreen: Screen("dashboard_screen")
    object uisatuScreen: Screen("uisatu_screen")
    object uiduaScreen: Screen("uidua_screen")
    object daftarnamaScreen: Screen("daftarnama_screen")
    object uilimaScreen: Screen("uilima_screen")
    object uienamScreen: Screen("uienam_screen")

}


class AppNavigator {
    @Composable
    fun screenNav(viewModel: VideosViewModel) {
        val navController = rememberNavController()

        NavHost(navController, startDestination = Screen.uilimaScreen.route) {
            composable(Screen.loginScreen.route) { entry ->
                LoginScreenUI(navController)
            }
            composable(Screen.splashScreen.route) { entry ->
                SplashScreenUI(navController)
            }
            composable(Screen.dashboardScreen.route) { entry ->
                DashboardScreenUI(navController)
            }
            composable(Screen.uisatuScreen.route) { entry ->
                InterfaceSatuUI(navController)
            }
            composable(Screen.uiduaScreen.route) { entry ->
                InterfaceDuaUI(navController)
            }
            composable(Screen.daftarnamaScreen.route) { entry ->
                EmployeeScreenUI(navController)
            }
            composable(Screen.uilimaScreen.route) { entry ->
                InterfaceLimaUI(navController, viewModel)
            }
            composable(Screen.uienamScreen.route,) { entry ->
                InterfaceEnamUI(navController, viewModel)
            }

        }
    }



    fun push(navController: NavHostController, screen: String) {
        navController.navigate(screen)
    }

    fun pushAndReplace(navController: NavHostController ,screen: String) {
        navController.navigate(screen) {
            popUpTo(navController.graph.id) {
                inclusive = true
            }
        }
    }




    fun pop(navController: NavHostController) {
        navController.popBackStack()
    }
}

fun push() {

}

