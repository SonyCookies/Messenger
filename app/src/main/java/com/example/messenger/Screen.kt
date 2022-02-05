package com.example.messenger

sealed class Screen(val route: String) {
    object GetStarted: Screen(route = "getStarted_screen")
    object Login: Screen(route = "login_screen")

}

