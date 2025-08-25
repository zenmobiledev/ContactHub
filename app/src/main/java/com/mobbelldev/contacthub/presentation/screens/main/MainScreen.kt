package com.mobbelldev.contacthub.presentation.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.mobbelldev.contacthub.R
import com.mobbelldev.contacthub.domain.model.User
import com.mobbelldev.contacthub.presentation.screens.main.component.MainContent
import com.mobbelldev.contacthub.presentation.screens.main.component.SearchTextField
import com.mobbelldev.contacthub.presentation.theme.ContactHubTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel(),
) {
    val users by viewModel.users.collectAsState()
    var isSearching by rememberSaveable { mutableStateOf(false) }
    var query by rememberSaveable { mutableStateOf("") }

    val filtered = if (query.isBlank()) {
        users
    } else users.filter {
        it.name.contains(query, true) ||
                it.company.name.contains(query, true)
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    if (isSearching) {
                        SearchTextField(
                            value = query,
                            onChange = { query = it },
                            onClear = {
                                query = ""
                                isSearching = false
                            }
                        )
                    } else {
                        Text(text = stringResource(R.string.app_name))
                    }
                },
                actions = {
                    IconButton(onClick = { isSearching = !isSearching }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = stringResource(R.string.search_contact)
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        when {
            users.isEmpty() -> {
                // Loading
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues = paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            filtered.isEmpty() -> {
                // Empty state
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues = paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = stringResource(R.string.no_users_found))
                }
            }

            else -> {
                // User list
                LazyColumn(modifier = Modifier.padding(paddingValues = paddingValues)) {
                    items(filtered) { user ->
                        MainContent(user = user)
                    }
                }
            }
        }
    }
}