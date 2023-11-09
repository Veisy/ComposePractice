package com.example.composepractice.ui.navigation_practices.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composepractice.ui.navigation_practices.Routes

@Composable
fun UsersScreen(navController: NavController) {
    val users = User.getTestList()
    LazyColumn() {
        items(users) {
            Column(
                modifier = Modifier
                    .padding(4.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .clickable {
                        navController.navigate(Routes.UserDetail.createRoute(it.id.toString()))
                    }
                    .fillMaxWidth()
                    .background(Color(0xFFEEEEEE))
                    .padding(8.dp)
            ) {
                Text(text = it.name, color = Color.DarkGray, style = MaterialTheme.typography.bodyLarge)
                Text(text = it.surname, color = Color.DarkGray, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}