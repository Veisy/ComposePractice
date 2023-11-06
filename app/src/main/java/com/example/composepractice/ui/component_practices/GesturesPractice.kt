package com.example.composepractice.ui.component_practices

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp

@Composable
fun GesturesPractice() {
    val gestureDetection = remember { mutableStateOf("No Gesture") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = gestureDetection.value)

        // `clickable` will be called even when we tap, double click or long press.
        // `clickable` will be overridden by `pointerInput`, and won't be called.
        val txtState = remember { mutableIntStateOf(0) }
        Box(modifier = Modifier
            .size(200.dp)
            .background(Color.Gray)
            //.clickable { txtState.intValue += 1 }
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = { gestureDetection.value = "onPress" },
                    onDoubleTap = { gestureDetection.value = "onDoubleTap" },
                    onLongPress = { gestureDetection.value = "onLongPress" },
                    onTap = { gestureDetection.value = "onTap x: ${it.x}, y: ${it.y}" },
                )
            }) {
            Text(
                text = "Clicked ${txtState.intValue} times",
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}