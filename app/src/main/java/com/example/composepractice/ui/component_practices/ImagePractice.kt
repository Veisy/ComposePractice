package com.example.composepractice.ui.component_practices

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import com.example.composepractice.R

@Composable
fun PracticeImage1() {
    Toast.makeText(LocalContext.current, "PracticeImage1", Toast.LENGTH_SHORT).show()
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.izmir),
            contentDescription = null,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentScale = ContentScale.Fit,
        )
        Image(
            painter = painterResource(id = R.drawable.ic_directions_bike),
            contentDescription = null,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentScale = ContentScale.Fit,
            colorFilter = ColorFilter.tint(color = Color.Green)
        )
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                model = "https://gezilecekyerler.com/wp-content/uploads/2016/12/Ak%C3%A7ay-Zeytinli.jpg",
                contentDescription = null
            )
        }
    }
}