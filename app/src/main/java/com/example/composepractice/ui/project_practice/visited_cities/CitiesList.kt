package com.example.composepractice.ui.project_practice.visited_cities

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CitiesList(
    cities: List<City>,
    onAddCity: (city: String, country: String) -> Unit,
    onSort: () -> Unit
) {
    val showAddCityDialog = remember { mutableStateOf(false) }
    Scaffold(
        topBar = { TopAppBar(onSort) },
        floatingActionButton = { AddCityFab { showAddCityDialog.value = true } }
    ) { paddingValues ->
        if (cities.isEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "No cities available", style = Typography().bodyMedium)
            }
        } else {
            LazyColumn(
                modifier = Modifier.padding(paddingValues),
                contentPadding = PaddingValues(10.dp)
            ) {
                items(cities) {
                    Column(
                        modifier = Modifier
                            .padding(5.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFFEEEEEE))
                            .padding(10.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = it.cityName,
                            style = Typography().bodyLarge,
                            color = Color.DarkGray
                        )
                        Spacer(modifier = Modifier.size(4.dp))
                        Text(
                            text = it.countryName,
                            style = Typography().bodyMedium,
                            color = Color.DarkGray
                        )
                    }
                }
            }
        }
    }

    if (showAddCityDialog.value) {
        AddCityDialog(
            onDismiss = {
                showAddCityDialog.value = false
            }, onConfirm = { city, country ->
                showAddCityDialog.value = false
                onAddCity.invoke(city, country)
            }
        )
    }
}

