package com.mobbelldev.contacthub.presentation.screens.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.mobbelldev.contacthub.R
import com.mobbelldev.contacthub.domain.model.User
import com.mobbelldev.contacthub.presentation.screens.detail.component.DetailContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    user: User?,
    viewModel: DetailViewModel = hiltViewModel(),
    onDial: (String) -> Unit,
) {
    val context = LocalContext.current

    LaunchedEffect(user) {
        user?.let {
            viewModel.getUser(
                user = it
            )
        }
    }

    user?.let {
        Scaffold(
            topBar = {
                TopAppBar(title = {
                    Text(text = it.name)
                })
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { onDial(it.phone) }
                ) {
                    Icon(Icons.Default.Phone, contentDescription = "call")
                }
            }
        ) { paddingValues ->

            Column(modifier = Modifier.padding(paddingValues = paddingValues)) {
                DetailContent(
                    user = it
                )
            }
        }
    } ?: @Composable {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = context.getString(R.string.data_is_null))
        }
    }
}
