package com.pradeep.splashscreen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Splash.route){
        composable(Screen.Splash.route){
            AnimatedSplashScreen(navController)
        }
        composable(Screen.Home.route){
            HomeScreen()
        }


    }
}