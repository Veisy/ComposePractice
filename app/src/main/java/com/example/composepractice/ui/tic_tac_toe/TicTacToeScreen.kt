package com.example.composepractice.ui.tic_tac_toe

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.example.composepractice.R

@Composable
fun TicTacToeScreen() {
    val playerTurn = remember { mutableStateOf(Player.X) }
    val moves = remember { MutableList<Player?>(9) { null } }
    val win = remember { mutableStateOf<Win?>(null) }

    val onTap: (Offset, IntSize) -> Unit = { offset, size ->
        if (win.value == null) {
            val (cellWidth, cellHeight) = size.width / 3 to size.height / 3
            val row = (offset.y / cellHeight).toInt().coerceAtMost(2)
            val col = (offset.x / cellWidth).toInt().coerceAtMost(2)
            val index = row * 3 + col
            if (moves[index] == null) {
                moves[index] = playerTurn.value
                playerTurn.value = playerTurn.value.toggle()
                win.value = checkEndGame(moves)
            }
        }
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Tic Tac Toe",
            modifier = Modifier.padding(top = 32.dp, bottom = 32.dp),
            style = Typography().titleLarge
        )
        Header(playerTurn.value)
        Board(moves = moves, onTap = onTap)
    }

    if (win.value != null) {
        val text = when (win.value) {
            Win.PLAYER_X -> "Player X won \uD83C\uDF89"
            Win.PLAYER_O -> "Player O won \uD83C\uDF89"
            else -> "Draw \uD83D\uDE33"
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = text,
                style = Typography().titleLarge,
            )
            Spacer(modifier = Modifier.size(32.dp))
            Button(onClick = {
                moves.clear()
                moves.addAll(MutableList(9) { null })
                win.value = null
                playerTurn.value = Player.X
            }) {
                Text(text = "Play Again")
            }
        }
    }
}

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

        TTTBox(text = "Player X", color = playerXBoxColor)
        Spacer(modifier = Modifier.width(50.dp))
        TTTBox(text = "Player O", color = playerOBoxColor)

    }
}

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
fun GetComposableFromMove(move: Player?) {
    when (move) {
        Player.X -> {
            Image(
                painter = painterResource(id = R.drawable.ic_x),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                colorFilter = ColorFilter.tint(Color.Blue)
            )
        }

        Player.O -> {
            Image(
                painter = painterResource(id = R.drawable.ic_o),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                colorFilter = ColorFilter.tint(Color.Red)
            )
        }

        null -> {
            Image(
                painter = painterResource(id = R.drawable.ic_null),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
            )
        }
    }
}

@Composable
fun TTTBox(text: String, color: Color) {
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

enum class Player {
    X {
        override fun toggle() = O
    },
    O {
        override fun toggle() = X
    };

    abstract fun toggle(): Player
}

enum class Win {
    PLAYER_X, PLAYER_O, DRAW
}

fun checkEndGame(moves: List<Player?>): Win? {
    val winningCombinations = listOf(
        listOf(0, 1, 2), listOf(3, 4, 5), listOf(6, 7, 8),
        listOf(0, 3, 6), listOf(1, 4, 7), listOf(2, 5, 8),
        listOf(0, 4, 8), listOf(2, 4, 6)
    )

    val winningCombination = winningCombinations.find { combination ->
        combination.all { moves[it] == Player.X }
                || combination.all { moves[it] == Player.O }
    }

    return when (winningCombination) {
        null -> if (moves.all { it != null }) Win.DRAW else null
        else -> if (moves[winningCombination[0]] == Player.X) Win.PLAYER_X else Win.PLAYER_O
    }
}
