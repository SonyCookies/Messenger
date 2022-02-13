package com.example.messenger.navigation

sealed class Screen(val route: String) {
    object GetStarted: Screen(route = "getStarted_screen")
    object Login: Screen(route = "login_screen")
    object Signup: Screen(route = "signup_screen")
    object Success: Screen(route = "success_screen")
    object Home: Screen(route = "home_screen")

}

