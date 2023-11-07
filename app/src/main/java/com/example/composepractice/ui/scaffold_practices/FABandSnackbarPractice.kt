package com.example.composepractice.ui.scaffold_practices

import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.launch


@Composable
fun FABandSnackbarPractice(snackbarHostState: SnackbarHostState) {
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    FloatingActionButton(onClick = {
        coroutineScope.launch {
            val result = snackbarHostState.showSnackbar(
                message = "Snackbar",
                actionLabel = "Action",
                duration = SnackbarDuration.Indefinite
            )
            when (result) {
                SnackbarResult.ActionPerformed -> {
                    Toast.makeText(context, "Action performed", Toast.LENGTH_SHORT).show()
                }

                SnackbarResult.Dismissed -> {
                    // Handle dismiss
                }
            }
        }
    }) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
    }
}