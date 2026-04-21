package com.example.pogo.model

/**
 * Data class representing a user profile stored in Firebase Realtime Database.
 */
data class UserProfile(
    val fullName: String = "",
    val nickname: String = "",
    val email: String = "",
    val mobileNumber: String = ""
)
