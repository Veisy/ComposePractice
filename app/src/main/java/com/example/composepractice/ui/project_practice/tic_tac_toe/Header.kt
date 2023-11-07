package com.example.composepractice.ui.project_practice.tic_tac_toe

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Header(playerTurn: Player) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        val playerXBoxColor: Color
        val playerOBoxColor: Color
        when (playerTurn) {
            Player.X -> {
                playerXBoxColor = Color.Blue
                playerOBoxColor = Color.LightGray
            }

            Player.O -> {
                playerXBoxColor = Color.LightGray
                playerOBoxColor = Color.Red
            }
        }

        PlayerHeaderBox(text = "Player X", color = playerXBoxColor)
        Spacer(modifier = Modifier.width(50.dp))
        PlayerHeaderBox(text = "Player O", color = playerOBoxColor)

    }
}

@Composable
fun PlayerHeaderBox(text: String, color: Color) {
    Box(
        modifier = Modifier
            .width(100.dp)
            .background(color)
    ) {
        Text(
            text = text, modifier = Modifier
                .padding(8.dp)
                .align(Alignment.Center)
        )
    }
}