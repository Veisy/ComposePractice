package com.example.composepractice.ui.navigation_practices

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import com.example.composepractice.ui.navigation_practices.screens.FeedScreen
import com.example.composepractice.ui.navigation_practices.screens.HomeScreen
import com.example.composepractice.ui.navigation_practices.screens.ProfileScreen
import com.example.composepractice.ui.navigation_practices.screens.UserDetailScreen
import com.example.composepractice.ui.navigation_practices.screens.UsersScreen

@Composable
fun NavigationHostPractice(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = Routes.Home.route,
        modifier = modifier
    ) {
        composable(Routes.Home.route) { HomeScreen(navController) }
        composable(Routes.Feed.route) { FeedScreen(navController) }
        composable(Routes.Profile.route) { ProfileScreen(navController) }
        composable(Routes.Users.route) { UsersScreen(navController) }
        composable(
            Routes.UserDetail.route,
            deepLinks = listOf(navDeepLink { uriPattern = "https://www.navpractice.com/{userId}" })
        ) { navBackStackEntry ->
            val userId = navBackStackEntry.arguments?.getString("userId")
            userId?.let { UserDetailScreen(userId = it.toInt()) }
        }
    }
}
