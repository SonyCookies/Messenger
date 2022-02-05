package com.example.messenger

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.GetStarted.route
    ) {
        composable(
            route = Screen.GetStarted.route
        ) {
            StartScreen(navController)
        }
        composable(
            route = Screen.Login.route
        ) {
            LoginScreen(navController)
        }
        composable(
            route = Screen.Signup.route
        ) {
            SignupScreen(navController)
        }
        composable(
            route = Screen.Signup.route
        ) {
            SuccessScreen(navController)
        }
    }
}