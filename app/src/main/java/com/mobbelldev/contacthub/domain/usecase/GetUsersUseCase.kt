package com.mobbelldev.contacthub.domain.usecase

import com.mobbelldev.contacthub.domain.model.User
import com.mobbelldev.contacthub.domain.repositories.UserRepository
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(private val repository: UserRepository) {
    suspend operator fun invoke(): List<User> = repository.getUsers()
}