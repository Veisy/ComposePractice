package com.example.composepractice.ui.navigation_practices

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController

@Composable
fun BottomNavPractice(
    navController: NavController,
    navBackStackEntryState: State<NavBackStackEntry?>
) {
    val currentDestination = navBackStackEntryState.value?.destination
    if (
        NavigationItem.items.any {
            it.route == currentDestination?.route
        }
    ) {
        NavigationBar {
            NavigationItem.items.forEach { item ->
                NavigationBarItem(
                    selected = currentDestination?.route == item.route,
                    icon = { Icon(imageVector = item.icon, contentDescription = null) },
                    label = { Text(text = item.label) },
                    onClick = {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    }
}