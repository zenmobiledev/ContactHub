package com.mobbelldev.contacthub.presentation.screens.detail

import androidx.lifecycle.ViewModel
import com.mobbelldev.contacthub.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor() : ViewModel() {
    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user

    fun getUser(user: User) {
        _user.value = user
    }
}