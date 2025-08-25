package com.mobbelldev.contacthub.presentation.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobbelldev.contacthub.domain.usecase.GetUsersUseCase
import com.mobbelldev.contacthub.presentation.screens.main.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow<UiState>(UiState.Loading)
    val state: StateFlow<UiState> = _state

    init {
        viewModelScope.launch {
            val users = getUsersUseCase()
            _state.value = if (users.isEmpty()) {
                UiState.Empty
            } else {
                UiState.Success(users)
            }
        }
    }
}