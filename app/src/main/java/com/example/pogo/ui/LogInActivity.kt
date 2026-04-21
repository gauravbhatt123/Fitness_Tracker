package com.example.pogo.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.pogo.R
import com.example.pogo.util.AuthManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.common.api.ApiException
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.GoogleAuthProvider

/**
 * Login screen with email/password and Google Sign-In.
 * Fixes: uses AuthManager instead of cross-activity companion object access,
 * proper validation order, and loading states.
 */
class LogInActivity : AppCompatActivity() {

    private lateinit var etEmail: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var btnLogin: MaterialButton
    private lateinit var progressBar: ProgressBar
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        // Bind views
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        progressBar = findViewById(R.id.progressBar)

        // Back button
        findViewById<View>(R.id.btnBack).setOnClickListener { finish() }

        // Navigate to sign up
        findViewById<TextView>(R.id.btnSignUp).setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
            finish()
        }

        // Forgot password
        findViewById<TextView>(R.id.btnForgotPassword).setOnClickListener {
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }

        // Google Sign-In
        googleSignInClient = GoogleSignIn.getClient(this, AuthManager.getGoogleSignInOptions())

        findViewById<View>(R.id.btnGoogle).setOnClickListener {
            googleSignInClient.signOut()
            googleSignInLauncher.launch(googleSignInClient.signInIntent)
        }

        // Email login
        btnLogin.setOnClickListener { attemptLogin() }
    }

    private fun attemptLogin() {
        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString()

        when {
            email.isEmpty() || password.isEmpty() -> {
                Toast.makeText(this, R.string.enter_all_details, Toast.LENGTH_SHORT).show()
                return
            }
            !AuthManager.isValidEmail(email) -> {
                Toast.makeText(this, R.string.invalid_email, Toast.LENGTH_SHORT).show()
                return
            }
        }

        setLoading(true)
        AuthManager.auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                setLoading(false)
                if (task.isSuccessful) {
                    Toast.makeText(this, R.string.login_successful, Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, StepsActivity::class.java))
                    finish()
                }
            }
            .addOnFailureListener { exception ->
                setLoading(false)
                Toast.makeText(this, exception.localizedMessage, Toast.LENGTH_LONG).show()
            }
    }

    private val googleSignInLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK && result.data != null) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                try {
                    val account = task.getResult(ApiException::class.java)
                    account?.let { firebaseAuthWithGoogle(it) }
                } catch (e: ApiException) {
                    Toast.makeText(this, "${getString(R.string.google_signin_failed)}: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }

    private fun firebaseAuthWithGoogle(account: GoogleSignInAccount) {
        setLoading(true)
        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        AuthManager.auth.signInWithCredential(credential)
            .addOnSuccessListener {
                setLoading(false)
                Toast.makeText(this, R.string.login_successful, Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, StepsActivity::class.java))
                finish()
            }
            .addOnFailureListener {
                setLoading(false)
                Toast.makeText(this, "${getString(R.string.auth_failed)}: ${it.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun setLoading(loading: Boolean) {
        progressBar.visibility = if (loading) View.VISIBLE else View.GONE
        btnLogin.isEnabled = !loading
        btnLogin.text = if (loading) "" else getString(R.string.log_in)
    }
}
