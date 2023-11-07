package com.example.composepractice.ui.scaffold_practices

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

enum class BottomIcons {
    LIST,
    SHARE,
    FAVORITE
}

@Composable
fun BottomAppBarPractice() {
    val selected = remember { mutableStateOf(BottomIcons.LIST) }

    BottomAppBar {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
        ) {
            Text(text = "Bottom bar", fontSize = 20.sp)
            IconButton(onClick = { selected.value = BottomIcons.LIST }) {
                Icon(
                    imageVector = Icons.Default.List,
                    contentDescription = null,
                    tint = if (selected.value == BottomIcons.LIST) Color.White else Color.Gray
                )
            }
            IconButton(onClick = { selected.value = BottomIcons.SHARE }) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = null,
                    tint = if (selected.value == BottomIcons.SHARE) Color.White else Color.Gray
                )
            }
            IconButton(onClick = { selected.value = BottomIcons.FAVORITE }) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = null,
                    tint = if (selected.value == BottomIcons.FAVORITE) Color.White else Color.Gray
                )
            }
        }
    }
}