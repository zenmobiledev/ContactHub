package com.mobbelldev.contacthub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.mobbelldev.contacthub.navigation.NavGraph
import com.mobbelldev.contacthub.presentation.theme.ContactHubTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContactHubTheme {
                NavGraph()
            }
        }
    }
}