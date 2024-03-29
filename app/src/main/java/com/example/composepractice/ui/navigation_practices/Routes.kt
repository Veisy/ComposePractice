package com.example.composepractice.ui.navigation_practices

sealed class Routes(val route: String, val label: String) {
    object Home: Routes(route = "home", label = "Home")
    object Notification: Routes(route = "notification", label = "Notification")
    object Users: Routes(route = "users", label = "Users")
    object UserDetail: Routes(route = "user_detail/{userId}", label = "User Detail") {
        fun createRoute(userId: String) = "user_detail/$userId"
    }

}