package com.example.composepractice.ui.navigation_practices

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController

@Composable
fun ScaffoldNavPractice(
    navController: NavHostController,
    drawerState: DrawerState,
    navBackStackEntryState: State<NavBackStackEntry?>
) {
    Scaffold(
        bottomBar = {
            BottomNavPractice(
                navController = navController,
                navBackStackEntryState = navBackStackEntryState,
            )
        },
        topBar = { TopAppBarNavPractice(drawerState = drawerState) },

        ) { paddingValues ->
        NavigationHostPractice(
            navController = navController,
            modifier = Modifier.padding(paddingValues)
        )
    }
}