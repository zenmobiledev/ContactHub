package com.mobbelldev.contacthub.data.source.remote.api

import com.mobbelldev.contacthub.data.source.remote.response.UserResponse
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<UserResponse>
}