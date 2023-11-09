package com.example.composepractice.ui.navigation_practices

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarNavPractice(drawerState: DrawerState) {
    val coroutine = rememberCoroutineScope()
    TopAppBar(
        title = { Text(text = "Compose Practice") },
        navigationIcon = {
            IconButton(onClick = {
                coroutine.launch {
                    if (drawerState.isClosed) {
                        drawerState.open()
                    } else {
                        drawerState.close()
                    }
                }
            }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = null)
            }
        }
    )
}