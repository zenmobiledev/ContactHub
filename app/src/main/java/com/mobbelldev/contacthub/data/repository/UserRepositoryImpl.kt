package com.mobbelldev.contacthub.data.repository

import android.util.Log
import com.mobbelldev.contacthub.data.mapper.toDomain
import com.mobbelldev.contacthub.data.mapper.toEntity
import com.mobbelldev.contacthub.data.source.local.dao.UserDao
import com.mobbelldev.contacthub.data.source.remote.api.ApiService
import com.mobbelldev.contacthub.domain.model.User
import com.mobbelldev.contacthub.domain.repositories.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val local: UserDao,
    private val remote: ApiService,
) : UserRepository {
    override suspend fun getUsers(forceRefresh: Boolean): List<User> {
        return try {
            // Fetch data from the API
            if (forceRefresh) {
                val remoteUsers = remote.getUsers()
                val domainUsers = remoteUsers.map { it.toDomain() }

                // Save data local into database
                local.clearUsers()
                local.insertUsers(domainUsers.map { it.toEntity() })
                domainUsers
            } else {
                // Try to load data from local cache first
                val cached = local.getAllUsers()
                if (cached.isNotEmpty()) {
                    cached.map { it.toDomain() }
                } else {
                    // If cache is empty, fetch data from API
                    val remoteUsers = remote.getUsers()
                    val domainUsers = remoteUsers.map { it.toDomain() }

                    local.insertUsers(domainUsers.map { it.toEntity() })
                    domainUsers
                }
            }

        } catch (e: Exception) {
            // If there is no internet connection or an error occurs
            Log.d("UserRepositoryImpl", "Error getUsers because: ${e.message}")
            local.getAllUsers().map { it.toDomain() }
        }
    }
}