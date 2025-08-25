package com.mobbelldev.contacthub.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mobbelldev.contacthub.data.source.local.dao.UserDao
import com.mobbelldev.contacthub.data.source.local.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}