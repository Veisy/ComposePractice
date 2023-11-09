package com.example.composepractice.ui.navigation_practices

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import coil.compose.AsyncImage

@Composable
fun ModalNavDrawerPractice(navController: NavHostController) {
    val navBackStackEntryState = navController.currentBackStackEntryAsState()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val currentDestination = navBackStackEntryState.value?.destination
    val coroutineScope = rememberCoroutineScope()
    ModalNavigationDrawer(drawerState = drawerState, drawerContent = {
        ModalDrawerSheet {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 12.dp, start = 8.dp, end = 8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .padding(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxHeight()
                            .aspectRatio(1f)
                            .clip(shape = CircleShape),
                        model = "https://www.artmajeur.com/medias/standard/c/l/clementereira/artwork/14737067_img-20210723-101210.jpg",
                        contentDescription = ""
                    )
                    Spacer(modifier = Modifier.size(16.dp))
                    Text(
                        text = "Corto",
                        fontWeight = FontWeight.Bold,
                    )
                }
                Spacer(modifier = Modifier.size(8.dp))
                Divider()
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "Your Shortcuts",
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.size(12.dp))
                NavigationItem.items.forEach {
                    NavigationDrawerItem(
                        label = { Text(text = it.label) },
                        selected = currentDestination?.route == it.route,
                        icon = { Icon(imageVector = it.icon, contentDescription = null) },
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
                        })
                }
            }
        }
    }) {
        Scaffold(
            bottomBar = {
                BottomNavPractice(
                    navController = navController,
                    navBackStackEntryState = navBackStackEntryState,
                    drawerState = drawerState
                )
            },
        ) { paddingValues ->
            NavigationHostPractice(
                navController = navController,
                modifier = Modifier.padding(paddingValues)
            )
        }
    }
}