package com.example.composepractice.ui.project_practice.visited_cities

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun AddCityDialog(onDismiss: () -> Unit, onConfirm: (city: String, country: String) -> Unit) {
    val cityName = remember { mutableStateOf(TextFieldValue("")) }
    val countryName = remember { mutableStateOf(TextFieldValue("")) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = "Add City",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(5.dp)
                )
            }
        },
        text = {
            Column(modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = cityName.value,
                    onValueChange = { cityName.value = it },
                    label = { Text(text = "City Name") },
                    modifier = Modifier.padding(5.dp)
                )
                OutlinedTextField(
                    value = countryName.value,
                    onValueChange = { countryName.value = it },
                    label = { Text(text = "Country Name") },
                    modifier = Modifier.padding(5.dp)
                )
            }
        },
        confirmButton = {
            Button(onClick = {
                if (cityName.value.text.isNotBlank() && countryName.value.text.isNotBlank()) {
                    onConfirm.invoke(cityName.value.text, countryName.value.text)
                    onDismiss()
                }
            }) {
                Text(text = "Add")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text(text = "Cancel")
            }
        }
    )
}