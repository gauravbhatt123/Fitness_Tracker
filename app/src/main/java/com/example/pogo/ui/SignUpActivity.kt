package com.example.pogo.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
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
 * Sign up screen with email/password and Google Sign-In.
 * Fixes: removed unused imports, dead UserDetail import, companion-object auth,
 * and added proper loading states and validation.
 */
class SignUpActivity : AppCompatActivity() {

    private lateinit var etFullName: TextInputEditText
    private lateinit var etEmail: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var etConfirmPassword: TextInputEditText
    private lateinit var btnSignUp: MaterialButton
    private lateinit var progressBar: ProgressBar
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // Bind views
        etFullName = findViewById(R.id.etFullName)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        btnSignUp = findViewById(R.id.btnSignUp)
        progressBar = findViewById(R.id.progressBar)

        // Back button
        findViewById<View>(R.id.btnBack).setOnClickListener { finish() }

        // Navigate to login
        findViewById<View>(R.id.btnLogin).setOnClickListener {
            startActivity(Intent(this, LogInActivity::class.java))
            finish()
        }

        // Google Sign-In setup
        googleSignInClient = GoogleSignIn.getClient(this, AuthManager.getGoogleSignInOptions())

        findViewById<View>(R.id.btnGoogle).setOnClickListener {
            googleSignInClient.signOut()
            googleSignInLauncher.launch(googleSignInClient.signInIntent)
        }

        // Email sign up
        btnSignUp.setOnClickListener { attemptSignUp() }
    }

    private fun attemptSignUp() {
        val fullName = etFullName.text.toString().trim()
        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString()
        val confirmPassword = etConfirmPassword.text.toString()

        // Validation
        when {
            fullName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() -> {
                Toast.makeText(this, R.string.enter_all_details, Toast.LENGTH_SHORT).show()
                return
            }
            !AuthManager.isValidEmail(email) -> {
                Toast.makeText(this, R.string.invalid_email, Toast.LENGTH_SHORT).show()
                return
            }
            password != confirmPassword -> {
                Toast.makeText(this, R.string.passwords_dont_match, Toast.LENGTH_SHORT).show()
                return
            }
            password.length < 6 -> {
                Toast.makeText(this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show()
                return
            }
        }

        setLoading(true)
        AuthManager.auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                setLoading(false)
                if (task.isSuccessful) {
                    Toast.makeText(this, R.string.registered_successfully, Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, AgeInputActivity::class.java))
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
            .addOnSuccessListener { authResult ->
                setLoading(false)
                val isNewUser = authResult.additionalUserInfo?.isNewUser == true
                if (isNewUser) {
                    Toast.makeText(this, R.string.registered_successfully, Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, AgeInputActivity::class.java))
                } else {
                    Toast.makeText(this, R.string.login_successful, Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, HomeActivity::class.java))
                }
                finish()
            }
            .addOnFailureListener {
                setLoading(false)
                Toast.makeText(this, "${getString(R.string.auth_failed)}: ${it.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun setLoading(loading: Boolean) {
        progressBar.visibility = if (loading) View.VISIBLE else View.GONE
        btnSignUp.isEnabled = !loading
        btnSignUp.text = if (loading) "" else getString(R.string.sign_up)
    }
}
