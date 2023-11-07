package com.example.composepractice.ui.scaffold_practices

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.composepractice.ui.component_practices.LazyLayoutPractice2
import com.example.composepractice.ui.component_practices.dogBreeds

@Composable
fun ScaffoldPractice() {
    val snackbarHostState = remember { SnackbarHostState() }
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