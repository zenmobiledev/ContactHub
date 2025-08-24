package com.mobbelldev.contacthub.data.repository

import com.mobbelldev.contacthub.data.mapper.toDomain
import com.mobbelldev.contacthub.data.source.remote.api.ApiService
import com.mobbelldev.contacthub.domain.model.User
import com.mobbelldev.contacthub.domain.repositories.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remote: ApiService,
) : UserRepository {
    override suspend fun getUsers(): List<User> {
        val response = remote.getUsers()
        return response.map { it.toDomain() }
    }
}