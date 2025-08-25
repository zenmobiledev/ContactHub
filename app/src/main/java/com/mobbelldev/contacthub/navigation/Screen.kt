package com.mobbelldev.contacthub.navigation

sealed class Screen(val route: String) {
    object Main : Screen(route = MAIN)
    object Detail : Screen(route = "$DETAIL/{userId}") {
        fun route(userId: Int) = "$DETAIL/$userId"
    }

    companion object {
        private const val MAIN = "main"
        private const val DETAIL = "detail"
    }
}