package com.example.pogo

import android.app.Activity
import android.app.Instrumentation.ActivityResult
import android.content.Context
import android.content.Intent
import android.credentials.CredentialManager
import android.credentials.CredentialOption
import android.credentials.GetCredentialRequest
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.pogo.model.UserDetail
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.CoroutineScope

/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc
	 *	@file 		3___b___sign_up
	 *	@date 		Saturday 04th of January 2025 08:45:57 AM
	 *	@title 		Page 1
	 *	@author
	 *	@keywords
	 *	@generator 	Export Kit v1.3.figma
	 *
	 */
class sign_up_activity : AppCompatActivity() {
    companion object {
        lateinit var auth: FirebaseAuth

        private lateinit var googleSignInClient: GoogleSignInClient

    }


    lateinit var enterusername: EditText
    lateinit var enterpassword: EditText
    lateinit var enternumber: EditText
    lateinit var enterconfirm: EditText
    private var viewsign_up: View? = null
    private var rectangle_14: View? = null
    private var rectangle_17: View? = null
    private val _16_04: TextView? = null
    private val vector: ImageView? = null
    private val vector_ek1: ImageView? = null
    private val vector__stroke_: ImageView? = null
    private val vector__stroke__ek1: ImageView? = null
    private var example_example_com: TextView? = null
    private var rectangle_16: View? = null
    private var rectangle_160: View? = null
    private var enterpass: TextView? = null
    private var rectangle_161: View? = null
    private var full_name: TextView? = null
    private var email_or_mobile_number: TextView? = null
    private var password: TextView? = null
    private var log_in: TextView? = null
    private var confirm_password: TextView? = null
    private var gmail_ek1: ImageView? = null
    private val mark_ek1: ImageView? = null
    private var vector_ek2: ImageView? = null
    private var rectangle_146: View? = null
    private var rectangle_145: View? = null
    private var sign_up: TextView? = null
    private lateinit var google_button: RelativeLayout
    private lateinit var facebook_icon: RelativeLayout
    private lateinit var firebaseRef : DatabaseReference
    private var vector_ek3: ImageView? = null
    private var create_account: TextView? = null
    private var already_have_an_account__log_in: TextView? = null
    private var or_sign_up_with: TextView? = null
    private var by_continuing__you_agree_to_terms_of_use_and_privacy_policy_: TextView? = null
    private var let_s_start_: TextView? = null
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up)
        enterusername = findViewById(R.id.enterusername)
        enterpassword = findViewById(R.id.enterpassword)
        enternumber = findViewById(R.id.enternumber)
        enterconfirm = findViewById(R.id.enterconfirm)
        viewsign_up = findViewById(R.id.viewsign_up) as View
        rectangle_14 = findViewById(R.id.rectangle_14) as View
        rectangle_17 = findViewById(R.id.rectangle_17) as View
        log_in = findViewById(R.id.log_in) as TextView
        rectangle_16 = findViewById(R.id.rectangle_16) as View
        rectangle_160 = findViewById(R.id.rectangle_160) as View
        rectangle_161 = findViewById(R.id.rectangle_161) as View

        full_name = findViewById<View>(R.id.full_name) as TextView
        email_or_mobile_number = findViewById<View>(R.id.email_or_mobile_number) as TextView
        password = findViewById<View>(R.id.password) as TextView

        confirm_password = findViewById<View>(R.id.confirm_password) as TextView
        gmail_ek1 = findViewById<View>(R.id.gmail_ek1) as ImageView
        vector_ek2 = findViewById<View>(R.id.vector_ek2) as ImageView
        rectangle_146 = findViewById(R.id.rectangle_146) as View
        rectangle_145 = findViewById(R.id.rectangle_145) as View
        sign_up = findViewById<View>(R.id.sign_up) as TextView
        vector_ek3 = findViewById<View>(R.id.vector_ek3) as ImageView
        create_account = findViewById<View>(R.id.create_account) as TextView
        google_button = findViewById<RelativeLayout>(R.id.google_icon)

        facebook_icon = findViewById<RelativeLayout>(R.id.facebook_icon)
        already_have_an_account__log_in =
            findViewById<View>(R.id.already_have_an_account__log_in) as TextView
        or_sign_up_with = findViewById<View>(R.id.or_sign_up_with) as TextView
        by_continuing__you_agree_to_terms_of_use_and_privacy_policy_ =
            findViewById<View>(R.id.by_continuing__you_agree_to_terms_of_use_and_privacy_policy_) as TextView
        let_s_start_ = findViewById<View>(R.id.let_s_start_) as TextView
        auth = FirebaseAuth.getInstance()
        log_in?.setOnClickListener()
        {
            val intent = Intent(this, log_in_activity::class.java)
            startActivity(intent)
            finish()
        }
        vector_ek3?.setOnClickListener()
        {
            val intent = Intent(this, third_activity::class.java)
            startActivity(intent)
            finish()
        }
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("754218514491-f815achjhuo2lusedm1nsj66nev08ulf.apps.googleusercontent.com")
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)
        google_button?.setOnClickListener()
        {
            googleSignInClient.signOut()
            val intent = googleSignInClient.signInIntent
            getResult.launch(intent)
        }

//        facebook_icon?.setOnClickListener()
//        {
//
//        }

        rectangle_145?.setOnClickListener {
            // Check if any field is empty
            if (enterusername.text.toString().isEmpty() ||
                enterpassword.text.toString().isEmpty() ||
                enternumber.text.toString().isEmpty() ||
                enterconfirm.text.toString().isEmpty()) {

                Toast.makeText(this, "Please enter all details", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Check if the email is valid
            if (!isValidEmail(enternumber.text.toString())) {
                Toast.makeText(this, "Enter a valid email address", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Check if passwords match
            if (enterpassword.text.toString() != enterconfirm.text.toString()) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            // Proceed with user registration
            val emaill = enternumber.text.toString()
            val passs = enterpassword.text.toString()
            auth.createUserWithEmailAndPassword(emaill, passs)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Registered Successfully", Toast.LENGTH_LONG).show()

                        val intent = Intent(this,Ageinput::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
                .addOnFailureListener { exception ->
                    Toast.makeText(this, exception.localizedMessage, Toast.LENGTH_LONG).show()
                }
        }



    }
    private val getResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK && result.data != null) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                try {
                    val account = task.getResult(ApiException::class.java)
                    if (account != null) {
                        signInWithGoogle(account)
                    }
                } catch (e: ApiException) {
                    Toast.makeText(this, "Google Sign-In Failed: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }


    private fun signInWithGoogle(account: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        auth.signInWithCredential(credential)
            .addOnSuccessListener {
                val firebaseUser = auth.currentUser
                if (firebaseUser != null) {
                    val email = firebaseUser.email
                    val isNewUser = it.additionalUserInfo?.isNewUser == true

                    if (isNewUser) {
                        // Sign-up logic for new users
                        Toast.makeText(this, "Sign-Up Successful with $email", Toast.LENGTH_LONG).show()

                        val intent = Intent(this,Ageinput::class.java)
                        startActivity(intent)
                        finish()

                    } else {
                        // Already signed up, proceed to login
                        Toast.makeText(this, "Already Registered. Logging in...", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this,home_activity::class.java)
                        startActivity(intent)
                        finish()
                    }

                    // Navigate to login page

                }
            }
            .addOnFailureListener {
                Toast.makeText(this, "Authentication Failed: ${it.message}", Toast.LENGTH_SHORT).show()
            }
    }
    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }




}