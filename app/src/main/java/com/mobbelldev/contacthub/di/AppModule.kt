package com.mobbelldev.contacthub.di

import com.mobbelldev.contacthub.data.repository.UserRepositoryImpl
import com.mobbelldev.contacthub.data.source.local.dao.UserDao
import com.mobbelldev.contacthub.data.source.remote.api.ApiService
import com.mobbelldev.contacthub.domain.repositories.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideUserRepository(
        remote: ApiService,
        local: UserDao,
    ): UserRepository {
        return UserRepositoryImpl(
            remote = remote,
            local = local
        )
    }
}