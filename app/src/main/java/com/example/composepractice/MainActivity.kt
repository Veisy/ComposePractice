package com.example.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.composepractice.ui.component_practices.LazyLayoutPractice2
import com.example.composepractice.ui.component_practices.dogBreeds
import com.example.composepractice.ui.scaffold_practices.BottomAppBarPractice
import com.example.composepractice.ui.scaffold_practices.FABandSnackbarPractice
import com.example.composepractice.ui.scaffold_practices.TopAppBarPractice
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
                    ScaffoldPractice()

                }
            }
        }
    }
}

@Composable
fun ScaffoldPractice() {
    val snackbarHostState = remember { SnackbarHostState()}
    Scaffold(
        topBar = { TopAppBarPractice() },
        bottomBar = { BottomAppBarPractice() },
        floatingActionButton = { FABandSnackbarPractice(snackbarHostState) },
        floatingActionButtonPosition = FabPosition.Center,
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },

    ) { paddingValues ->
        LazyLayoutPractice2(
            dogs = dogBreeds,
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        )
    }
}


