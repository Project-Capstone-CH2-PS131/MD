package com.example.capstone.data.pref

data class UserPreference (
    val email: String,
    val token: String,
    val isLogin: Boolean = false
)