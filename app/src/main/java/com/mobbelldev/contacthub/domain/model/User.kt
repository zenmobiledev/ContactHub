package com.mobbelldev.contacthub.domain.model

data class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val phone: String,
    val website: String,
    val address: Address,
    val company: Company,
) {
    data class Address(
        val zipcode: String,
        val geo: Geo,
        val suite: String,
        val city: String,
        val street: String,
    )

    data class Company(
        val bs: String,
        val catchPhrase: String,
        val name: String,
    )

    data class Geo(
        val lng: String,
        val lat: String,
    )
}