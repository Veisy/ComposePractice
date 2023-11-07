package com.example.composepractice.ui.project_practice.tic_tac_toe

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

@Composable
fun Board(moves: List<Player?>, onTap: (Offset, IntSize) -> Unit) {
    val sizeOfBox = remember { mutableStateOf(IntSize.Zero) }
    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .padding(32.dp)
            .background(Color.Gray)
            .onGloballyPositioned {
                sizeOfBox.value = it.size
            }
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        onTap(it, sizeOfBox.value)
                    }
                )
            }
    ) {
        Column(verticalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxSize()) {
            repeat(2) {
                HorizontalBar()
            }
        }
        Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxSize()) {
            repeat(2) {
                VerticalBar()
            }
        }
        Column(modifier = Modifier.fillMaxSize()) {
            repeat(3) { i ->
                Row(modifier = Modifier.weight(1f)) {
                    repeat(3) { j ->
                        Column(modifier = Modifier.weight(1f)) {
                            GetComposableFromMove(moves[i * 3 + j])
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun HorizontalBar() {
    Row(
        modifier = Modifier
            .height(2.dp)
            .fillMaxWidth()
            .background(Color.Black)
    ) {}

}

@Composable
fun VerticalBar() {
    Column(
        modifier = Modifier
            .width(2.dp)
            .fillMaxHeight()
            .background(Color.Black)
    ) {}
}