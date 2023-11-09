package com.example.composepractice.ui.navigation_practices

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
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
                label = Routes.Notification.label,
                route = Routes.Notification.route,
                icon = Icons.Default.Notifications
            ),
        )
    }
}
