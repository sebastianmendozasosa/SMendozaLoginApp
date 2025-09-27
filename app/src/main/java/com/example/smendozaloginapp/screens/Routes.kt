package com.example.smendozaloginapp.screens

import kotlinx.serialization.Serializable

@Serializable
data class UserData(val email: String)

@Serializable
data class LoginScreenRoute(
    val userData: UserData? = null
)

@Serializable
object RegisterScreenRoute