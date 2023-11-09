package com.example.composepractice.ui.navigation_practices

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val label: String = "",
    val route: String,
    val icon: ImageVector
) {
    companion object {
        val items = listOf(
            NavigationItem(
                label = Routes.Home.label,
                route = Routes.Home.route,
                icon = Icons.Default.Home
            ),
            NavigationItem(
                label = Routes.Feed.label,
                route = Routes.Feed.route,
                icon = Icons.Default.List
            ),
            NavigationItem(
                label = Routes.Profile.label,
                route = Routes.Profile.route,
                icon = Icons.Default.Person
            ),
        )
    }
}