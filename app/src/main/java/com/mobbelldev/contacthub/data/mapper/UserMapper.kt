package com.mobbelldev.contacthub.data.mapper

import com.mobbelldev.contacthub.data.source.remote.response.UserResponse
import com.mobbelldev.contacthub.domain.model.User

fun UserResponse.toDomain(): User {
    return User(
        id = id,
        name = name,
        username = username,
        email = email,
        phone = phone,
        website = website,
        address = address.toAddress(),
        company = company.toCompany()
    )
}

private fun UserResponse.Address.toAddress(): User.Address {
    return User.Address(
        street = street,
        suite = suite,
        city = city,
        zipcode = zipcode,
        geo = geo.toGeo(),
    )
}

private fun UserResponse.Geo.toGeo(): User.Geo {
    return User.Geo(
        lng = lng,
        lat = lat
    )
}

private fun UserResponse.Company.toCompany(): User.Company {
    return User.Company(
        bs = bs,
        catchPhrase = catchPhrase,
        name = name
    )
}

