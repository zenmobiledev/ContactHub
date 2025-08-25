package com.mobbelldev.contacthub.navigation

sealed class Screen(val route: String) {
    object Main : Screen(route = MAIN)
    object Detail : Screen(route = DETAIL)

    companion object {
        private const val MAIN = "main"
        private const val DETAIL = "detail"
    }
}