package com.example.tumblrapp.ui.navigation

sealed class AppScreen(val route: String) {
    object Home: AppScreen(route = RouterConstants.HOME_ROUTE)
    object Details: AppScreen(route = RouterConstants.DETAILS_ROUTE)
}

object RouterConstants {
    const val HOME_ROUTE = "home"
    const val DETAILS_ROUTE = "details"
    const val BLOGPOST_ARG = "blogpost"
}
