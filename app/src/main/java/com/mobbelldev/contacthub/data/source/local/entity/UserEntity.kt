package com.mobbelldev.contacthub.data.source.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val phone: String,
    val website: String,
    @Embedded(prefix = "company_") val company: CompanyEntity,
    @Embedded(prefix = "address_") val address: AddressEntity,
) {
    data class CompanyEntity(
        val name: String,
        val catchPhrase: String,
        val bs: String,
    )

    data class AddressEntity(
        val street: String,
        val suite: String,
        val city: String,
        val zipcode: String,
        @Embedded(prefix = "geo_") val geo: GeoEntity,
    )

    data class GeoEntity(
        val lat: String,
        val lng: String,
    )
}
