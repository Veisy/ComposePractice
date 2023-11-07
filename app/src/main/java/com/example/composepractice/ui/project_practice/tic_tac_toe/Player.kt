package com.example.composepractice.ui.project_practice.tic_tac_toe

enum class Player {
    X {
        override fun toggle() = O
    },
    O {
        override fun toggle() = X
    };

    abstract fun toggle(): Player
}