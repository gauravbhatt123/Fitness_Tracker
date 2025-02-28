package com.example.pogo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		3_1___a___forgotten_password_
	 *	@date 		Monday 06th of January 2025 08:50:03 AM
	 *	@title 		FitBody App
	 *	@author 	
	 *	@keywords 	
	 *	@generator 	Export Kit v1.3.figma
	 *
	 */
class forgotten_password__activity : Activity() {
    private lateinit var auth:FirebaseAuth
    private var _bg___3_1___a___forgotten_password_: View? = null
    private var rectangle_146: View? = null
    private var rectangle_145: View? = null
    private var _16_04: TextView? = null
    private var vector: ImageView? = null
    private var vector_ek1: ImageView? = null
    private var vector__stroke_: ImageView? = null
    private var vector__stroke__ek1: ImageView? = null
    private var rectangle_160: View? = null
    private var enter_your_email_address: TextView? = null
    private var rectangle_146_ek1: View? = null
    private var rectangle_145_ek1: View? = null
    private var continue1: TextView? = null
    private var vector_ek2: ImageView? = null
    private var forgotten_password: TextView? = null
    private var forgot_password_: TextView? = null
    private lateinit var example_example_com: EditText
    private var lorem_ipsum_dolor_sit_amet__consectetur_adipiscing_elit__sed_do_eiusmod_tempor_incididunt_ut_labore_et_dolore_magna_aliqua_: TextView? =
        null

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.forgotten_password_)
        _bg___3_1___a___forgotten_password_ =findViewById(R.id._bg___3_1___a___forgotten_password_) as View
        rectangle_146 = findViewById(R.id.rectangle_146) as View
        rectangle_145 = findViewById(R.id.rectangle_145) as View
        rectangle_160 = findViewById(R.id.rectangle_160) as View
        enter_your_email_address = findViewById<View>(R.id.enter_your_email_address) as TextView
        rectangle_146_ek1 = findViewById(R.id.rectangle_146_ek1) as View
        rectangle_145_ek1 = findViewById(R.id.rectangle_145_ek1) as View
        continue1 = findViewById<View>(R.id.continue1) as TextView
        vector_ek2 = findViewById<View>(R.id.vector_ek2) as ImageView
        forgotten_password = findViewById<View>(R.id.forgotten_password) as TextView
        forgot_password_ = findViewById<View>(R.id.forgot_password_) as TextView
        example_example_com = findViewById(R.id.example_example_com)
        lorem_ipsum_dolor_sit_amet__consectetur_adipiscing_elit__sed_do_eiusmod_tempor_incididunt_ut_labore_et_dolore_magna_aliqua_ =
            findViewById<View>(R.id.lorem_ipsum_dolor_sit_amet__consectetur_adipiscing_elit__sed_do_eiusmod_tempor_incididunt_ut_labore_et_dolore_magna_aliqua_) as TextView
        auth=FirebaseAuth.getInstance()
        vector_ek2?.setOnClickListener()
        {
            val intent = Intent(this, log_in_activity::class.java)
            startActivity(intent)
            finish()
        }
        continue1?.setOnClickListener {
            val email = example_example_com.text.toString()

            if (!isValidEmail(email)) {
                Toast.makeText(this, "Enter a valid email address", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Check if email is registered
            auth.fetchSignInMethodsForEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val signInMethods = task.result?.signInMethods ?: emptyList()
                        if (signInMethods.isNotEmpty()) {
                            // Email is registered, send password reset email
                            auth.sendPasswordResetEmail(email)
                                .addOnSuccessListener {
                                    Toast.makeText(this, "Mail Sent!!", Toast.LENGTH_SHORT).show()
                                }
                                .addOnFailureListener { exception ->
                                    Toast.makeText(this, exception.message ?: "Error occurred", Toast.LENGTH_SHORT).show()
                                }
                        } else {
                            // Email is not registered
                            Toast.makeText(this, "This email is not registered", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        // Error fetching sign-in methods
                        Toast.makeText(this, "Error: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
        }


    }
    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
