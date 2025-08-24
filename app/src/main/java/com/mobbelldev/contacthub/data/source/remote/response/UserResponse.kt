package com.mobbelldev.contacthub.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("username")
    val username: String,

    @field:SerializedName("email")
    val email: String,

    @field:SerializedName("phone")
    val phone: String,

    @field:SerializedName("website")
    val website: String,

    @field:SerializedName("address")
    val address: Address,

    @field:SerializedName("company")
    val company: Company,
) {
    data class Address(
        @field:SerializedName("zipcode")
        val zipcode: String,

        @field:SerializedName("geo")
        val geo: Geo,

        @field:SerializedName("suite")
        val suite: String,

        @field:SerializedName("city")
        val city: String,

        @field:SerializedName("street")
        val street: String,
    )

    data class Company(
        @field:SerializedName("bs")
        val bs: String,

        @field:SerializedName("catchPhrase")
        val catchPhrase: String,

        @field:SerializedName("name")
        val name: String,
    )

    data class Geo(
        @field:SerializedName("lng")
        val lng: String,

        @field:SerializedName("lat")
        val lat: String,
    )
}