package com.mobbelldev.contacthub.data.mapper

import com.mobbelldev.contacthub.data.source.local.entity.UserEntity
import com.mobbelldev.contacthub.domain.model.User

// Domain -> Entity
fun User.toEntity(): UserEntity {
    return UserEntity(
        id = id,
        name = name,
        username = username,
        email = email,
        phone = phone,
        website = website,
        company = company.toEntity(),
        address = address.toEntity()
    )
}

private fun User.Company.toEntity(): UserEntity.CompanyEntity {
    return UserEntity.CompanyEntity(
        name = name,
        catchPhrase = catchPhrase,
        bs = bs
    )
}

private fun User.Address.toEntity(): UserEntity.AddressEntity {
    return UserEntity.AddressEntity(
        street = street,
        suite = suite,
        city = city,
        zipcode = zipcode,
        geo = geo.toEntity()
    )
}

private fun User.Geo.toEntity(): UserEntity.GeoEntity {
    return UserEntity.GeoEntity(
        lat = lat,
        lng = lng
    )
}

// Entity -> Domain
fun UserEntity.toDomain(): User {
    return User(
        id = id,
        name = name,
        username = username,
        email = email,
        phone = phone,
        website = website,
        company = company.toDomain(),
        address = address.toDomain()
    )
}

private fun UserEntity.CompanyEntity.toDomain(): User.Company {
    return User.Company(
        name = name,
        catchPhrase = catchPhrase,
        bs = bs
    )
}

private fun UserEntity.AddressEntity.toDomain(): User.Address {
    return User.Address(
        street = street,
        suite = suite,
        city = city,
        zipcode = zipcode,
        geo = geo.toDomain()
    )
}

private fun UserEntity.GeoEntity.toDomain(): User.Geo {
    return User.Geo(
        lat = lat,
        lng = lng
    )
}