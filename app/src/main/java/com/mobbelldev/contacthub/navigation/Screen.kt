package com.mobbelldev.contacthub.navigation

sealed class Screen(val route: String) {
    object Main : Screen(route = MAIN)

    companion object {
        private const val MAIN = "main"
    }
}