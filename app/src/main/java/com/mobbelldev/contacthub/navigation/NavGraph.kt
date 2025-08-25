package com.mobbelldev.contacthub.navigation

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.net.toUri
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mobbelldev.contacthub.domain.model.User
import com.mobbelldev.contacthub.presentation.screens.detail.DetailScreen
import com.mobbelldev.contacthub.presentation.screens.main.MainScreen
import com.mobbelldev.contacthub.util.Constant

@Composable
fun NavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = Screen.Main.route) {

        // Main page
        composable(route = Screen.Main.route) { backStackEntry ->
            MainScreen(
                onItemClicked = { user ->
                    backStackEntry.savedStateHandle[Constant.USER] = user
                    navController.navigate(Screen.Detail.route)
                }
            )
        }

        // Detail page
        composable(route = Screen.Detail.route) { backStackEntry ->
            val context = LocalContext.current
            val user = navController.previousBackStackEntry
                ?.savedStateHandle
                ?.get<User>(Constant.USER)

            DetailScreen(
                userParam = user,
                onDial = { phoneNumber ->
                    val intent = Intent(Intent.ACTION_DIAL, "tel:$phoneNumber".toUri())
                    context.startActivity(intent)
                }
            )
        }
    }
}