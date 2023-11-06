package com.example.composepractice.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.composepractice.R

@Composable
fun ScrollablePractice() {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        repeat(10) {
            Text(text = stringResource(id = R.string.lorem_ipsum))
            Text(text = "\n")
        }
    }
}