package com.example.composepractice.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color

@Composable
fun AlertDialogPractice() {
    val openDialog = remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { openDialog.value = true }) {
            Text(text = "Open Dialog")
        }
        if (openDialog.value) {
            AlertDialog(
                title = {
                    Text(text = "Title is This", color = Color.Cyan)
                },
                text = {
                    Text(text = "This is a message", color = Color.Magenta)
                },
                onDismissRequest = { openDialog.value = false }, // If we click outside of dialog, it will be dismissed
                confirmButton = {
                    Button(onClick = { openDialog.value = false }) {
                        Text(text = "Confirm", color = Color.Green)
                    }
                },
                dismissButton = {
                    Button(onClick = { openDialog.value = false }) {
                        Text(text = "Dismiss", color = Color.Red)
                    }
                }
            )
        }
    }
}