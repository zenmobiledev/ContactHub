package com.mobbelldev.contacthub.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val phone: String,
    val website: String,
    val address: Address,
    val company: Company,
) : Parcelable {
    @Parcelize
    data class Address(
        val zipcode: String,
        val geo: Geo,
        val suite: String,
        val city: String,
        val street: String,
    ) : Parcelable

    @Parcelize
    data class Company(
        val bs: String,
        val catchPhrase: String,
        val name: String,
    ) : Parcelable

    @Parcelize
    data class Geo(
        val lng: String,
        val lat: String,
    ) : Parcelable
}