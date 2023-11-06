package com.example.composepractice.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LayoutPractice() {
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color(0xffff0000))
            ) {}
            Spacer(modifier = Modifier.weight(0.2f))
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color(0xff00ff00))
            ) {}
            Spacer(modifier = Modifier.weight(0.2f))
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color(0xff0000ff))
            ) {}
        }
        Spacer(modifier = Modifier.weight(0.5f))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color(0xffffff00))
        ) {}
        Spacer(modifier = Modifier.weight(0.5f))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color(0xffffaa00))
        ) {}
        Spacer(modifier = Modifier.weight(0.5f))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color(0xffff00ff))
        ) {}
        Spacer(modifier = Modifier.weight(0.5f))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
                .background(Color(0xff0055ff)),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize(0.8f)
                    .background(Color(0xff0099ff))
            ) {}
            Row(
                modifier = Modifier
                    .fillMaxSize(0.6f)
                    .background(Color(0xff00ccff))
            ) {}
        }
    }
}
