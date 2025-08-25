package com.mobbelldev.contacthub.presentation.screens.main.util

import com.mobbelldev.contacthub.domain.model.User

sealed class UiState {
    object Loading : UiState()
    object Empty : UiState()
    data class Success(val data: List<User>) : UiState()
}