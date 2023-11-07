package com.example.composepractice.ui.project_practice.visited_cities

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.composepractice.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(onSort: () -> Unit) {
    TopAppBar(
        title = {
            Text(text = "Visited Cities")
        },
        actions = {
            IconButton(onClick = onSort) {
                Icon(painter = painterResource(R.drawable.ic_sort), contentDescription = null)
            }
        }
    )
}