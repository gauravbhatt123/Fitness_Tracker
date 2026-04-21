package com.example.pogo.ui

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pogo.R
import com.example.pogo.util.AuthManager
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

/**
 * Forgot password screen — sends a password reset email via Firebase Auth.
 * Fixes: extends AppCompatActivity (was raw Activity), proper error handling.
 */
class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var etEmail: TextInputEditText
    private lateinit var btnSendReset: MaterialButton
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        etEmail = findViewById(R.id.etEmail)
        btnSendReset = findViewById(R.id.btnSendReset)
        progressBar = findViewById(R.id.progressBar)

        findViewById<View>(R.id.btnBack).setOnClickListener { finish() }

        btnSendReset.setOnClickListener { attemptPasswordReset() }
    }

    private fun attemptPasswordReset() {
        val email = etEmail.text.toString().trim()

        if (!AuthManager.isValidEmail(email)) {
            Toast.makeText(this, R.string.invalid_email, Toast.LENGTH_SHORT).show()
            return
        }

        setLoading(true)
        AuthManager.auth.fetchSignInMethodsForEmail(email)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val signInMethods = task.result?.signInMethods ?: emptyList()
                    if (signInMethods.isNotEmpty()) {
                        AuthManager.auth.sendPasswordResetEmail(email)
                            .addOnSuccessListener {
                                setLoading(false)
                                Toast.makeText(this, R.string.reset_email_sent, Toast.LENGTH_SHORT).show()
                                finish()
                            }
                            .addOnFailureListener { exception ->
                                setLoading(false)
                                Toast.makeText(this, exception.message ?: "Error", Toast.LENGTH_SHORT).show()
                            }
                    } else {
                        setLoading(false)
                        Toast.makeText(this, R.string.email_not_registered, Toast.LENGTH_SHORT).show()
                    }
                } else {
                    setLoading(false)
                    Toast.makeText(this, "Error: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun setLoading(loading: Boolean) {
        progressBar.visibility = if (loading) View.VISIBLE else View.GONE
        btnSendReset.isEnabled = !loading
        btnSendReset.text = if (loading) "" else getString(R.string.send_reset_link)
    }
}
