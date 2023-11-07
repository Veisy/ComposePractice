package com.example.composepractice.ui.scaffold_practices

import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarPractice() {
    val context = LocalContext.current
    val showMenu = remember { mutableStateOf(false) }
    TopAppBar(
        title = {
            Text("Top App Bar")
        },
        navigationIcon = {
            IconButton(onClick = {
                Toast.makeText(context, "Navigation Icon Clicked", Toast.LENGTH_SHORT).show()
            }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = null)
            }
        },
        actions = {
            IconButton(onClick = {
                Toast.makeText(context, "Action Icon Clicked", Toast.LENGTH_SHORT).show()
            }) {
                Icon(imageVector = Icons.Default.Favorite, contentDescription = null)
            }
            IconButton(onClick = {
                showMenu.value = true
            }) {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
            }

            DropdownMenu(expanded = showMenu.value, onDismissRequest = { showMenu.value = false }) {
                DropdownMenuItem(
                    text = {
                        Text(text = "Settings")

                    },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Settings, contentDescription = null)
                    },
                    onClick = {
                        Toast.makeText(context, "Settings icon clicked!", Toast.LENGTH_SHORT).show()
                    }
                )
                DropdownMenuItem(
                    text = {
                        Text(text = "Email")
                    },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Email, contentDescription = null)
                    },
                    onClick = {
                        Toast.makeText(context, "Email icon clicked!", Toast.LENGTH_SHORT).show()
                    }
                )

            }
        }
    )
}