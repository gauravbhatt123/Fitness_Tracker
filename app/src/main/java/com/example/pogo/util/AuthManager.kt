package com.example.pogo.util

import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth

/**
 * Centralized authentication manager.
 * Eliminates the fragile companion-object-based auth sharing between activities.
 */
object AuthManager {

    val auth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }

    /** Google OAuth client ID — replace with your own from Firebase Console. */
    const val GOOGLE_CLIENT_ID =
        "754218514491-f815achjhuo2lusedm1nsj66nev08ulf.apps.googleusercontent.com"

    fun getGoogleSignInOptions(): GoogleSignInOptions {
        return GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(GOOGLE_CLIENT_ID)
            .requestEmail()
            .build()
    }

    fun isLoggedIn(): Boolean = auth.currentUser != null

    fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
