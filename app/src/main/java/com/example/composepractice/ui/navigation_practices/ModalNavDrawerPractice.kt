package com.example.composepractice.ui.navigation_practices

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import kotlinx.coroutines.launch

@Composable
fun ModalNavDrawerPractice(navController: NavHostController) {
    val navBackStackEntryState = navController.currentBackStackEntryAsState()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val currentDestination = navBackStackEntryState.value?.destination
    val coroutineScope = rememberCoroutineScope()
    ModalNavigationDrawer(drawerState = drawerState, drawerContent = {
        ModalDrawerSheet {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .padding(64.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Drawer Content", style = MaterialTheme.typography.titleLarge)
            }
            Divider()
            NavigationItem.items.forEach {
                NavigationDrawerItem(label = { Text(text = it.label) },
                    selected = currentDestination?.route == it.route,
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        if (currentDestination?.route != it.route) {
                            navController.navigate(it.route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    },
                    icon = { Icon(imageVector = it.icon, contentDescription = null) })
            }
        }
    }) {
        ScaffoldNavPractice(
            navController = navController,
            drawerState = drawerState,
            navBackStackEntryState = navBackStackEntryState
        )
    }
}