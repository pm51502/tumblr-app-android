package com.example.tumblrapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.tumblrapp.domain.models.Blogpost
import com.example.tumblrapp.ui.screens.DetailsScreen
import com.example.tumblrapp.ui.screens.HomeScreen
import com.google.gson.Gson

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AppScreen.Home.route,
    ) {
        composable(route = AppScreen.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(
            route = "${AppScreen.Details.route}/{${RouterConstants.BLOGPOST_ARG}}",
            arguments = listOf(
                navArgument(name = RouterConstants.BLOGPOST_ARG) {
                    type = BlogpostArgType()
                }
            )
        ) { navBackStackEntry ->
            val blogpost = navBackStackEntry.arguments?.getString(RouterConstants.BLOGPOST_ARG)
                ?.let { Gson().fromJson(it, Blogpost::class.java) }

            DetailsScreen(blogpost = blogpost)
        }
    }
}
