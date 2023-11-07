package com.example.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.composepractice.ui.project_practice.visited_cities.CitiesList
import com.example.composepractice.ui.project_practice.visited_cities.City
import com.example.composepractice.ui.theme.ComposePracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val cities = remember { mutableStateListOf<City>() }
                    val sort = remember { mutableStateOf(false) }
                    val sortedCities = if (sort.value) cities.sortedBy { it.cityName } else cities
                    CitiesList(
                        cities = sortedCities,
                        onAddCity = { city, country ->
                            cities.add(City(city, country))
                        },
                        onSort = {
                            sort.value = !sort.value
                        }
                    )
                }
            }
        }
    }
}




