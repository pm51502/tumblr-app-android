package com.example.tumblrapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tumblrapp.R
import com.example.tumblrapp.ui.navigation.AppScreen
import com.example.tumblrapp.ui.navigation.navigateToScreen
import com.example.tumblrapp.ui.shared.components.BlogpostList
import com.example.tumblrapp.ui.shared.components.ScreenTitle
import com.example.tumblrapp.viewmodels.HomeViewModel
import org.koin.androidx.compose.viewModel

@Composable
fun HomeScreen(navController: NavController) {
    val homeViewModel by viewModel<HomeViewModel>()

    Column(
        modifier = Modifier.padding(15.dp)
    ) {
        ScreenTitle(title = stringResource(id = R.string.home_screen))

        Button(onClick = { homeViewModel.clearDb() }) {
            Text(text = stringResource(id = R.string.clear_database))
        }

        BlogpostList(
            blogpostFlow = homeViewModel.blogposts,
            onItemClick = {
                navigateToScreen(
                    navController = navController,
                    route = "${AppScreen.Details.route}/$it"
                )
            }
        )
    }
}
