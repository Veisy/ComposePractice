package com.example.composepractice.ui.component_practices

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.composepractice.R

@Composable
fun TextPractice() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = stringResource(R.string.simple_text))
        Spacer(modifier = Modifier.height(16.dp))

        val nameText = remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = nameText.value,
            onValueChange = { nameText.value = it }
        )
    }
}

