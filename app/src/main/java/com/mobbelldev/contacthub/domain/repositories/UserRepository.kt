package com.mobbelldev.contacthub.domain.repositories

import com.mobbelldev.contacthub.domain.model.User

interface UserRepository {
    suspend fun getUsers(): List<User>
}