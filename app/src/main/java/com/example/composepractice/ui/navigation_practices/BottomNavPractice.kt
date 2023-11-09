package com.example.composepractice.ui.navigation_practices

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@Composable
fun BottomNavPractice(
    navController: NavController,
    navBackStackEntryState: State<NavBackStackEntry?>,
    drawerState: DrawerState
) {
    val coroutineScope = rememberCoroutineScope()
    val currentDestination = navBackStackEntryState.value?.destination
    if (
        NavigationItem.items.any {
            it.route == currentDestination?.route
        }
    ) {
        NavigationBar {
            NavigationItem.items.forEach {
                NavigationBarItem(
                    selected = currentDestination?.route == it.route,
                    icon = { Icon(imageVector = it.icon, contentDescription = null) },
                    label = { Text(text = it.label) },
                    onClick = {
                        if (currentDestination?.route != it.route) {
                            navController.navigate(it.route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                )
            }
            NavigationBarItem(
                selected = drawerState.isOpen,
                onClick = {
                    coroutineScope.launch {
                        if (drawerState.isClosed) drawerState.open()
                        else drawerState.close()
                    }
                },
                label = { Text(text = "Menu") },
                icon = { Icon(Icons.Default.Menu, contentDescription = null) })
        }
    }
}