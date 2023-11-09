package com.example.composepractice.ui.navigation_practices.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.composepractice.ui.navigation_practices.NavigationItem
import com.example.composepractice.ui.navigation_practices.Routes

@Composable
fun Notification(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "${Routes.Notification.label} Screen", style = MaterialTheme.typography.titleLarge)
        NavigationItem.items.forEach {
            if (it.route != Routes.Notification.route) {
                Button(onClick = {
                    navController.navigate(it.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }) {
                    Text(text = "Go to ${it.label} Screen")
                }
            }
        }
    }
}