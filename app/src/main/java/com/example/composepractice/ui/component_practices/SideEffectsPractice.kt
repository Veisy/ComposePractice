package com.example.composepractice.ui.component_practices

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SideEffectsPractice() {
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    val showProgress = remember { mutableStateOf(false) }
    val launchEffect = remember { mutableStateOf(false) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            showProgress.value = true
            launchEffect.value = true
        }) {
            Text(text = "Start Progress")
        }

        if (showProgress.value) {
            CircularProgressIndicator()
        }

        if (launchEffect.value) {
            LaunchedEffect(key1 = Unit) {
                coroutineScope.launch {
                    delay(2000)
                    Toast.makeText(context, "Progress Completed", Toast.LENGTH_SHORT).show()
                    showProgress.value = false
                    launchEffect.value = false
                }
            }
        }
    }
}