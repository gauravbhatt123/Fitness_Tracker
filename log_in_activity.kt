package com.example.pogo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.database.FirebaseDatabase

/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc
	 *	@file 		3___a___log_in
	 *	@date 		Saturday 04th of January 2025 08:45:45 AM
	 *	@title 		Page 1
	 *	@author
	 *	@keywords
	 *	@generator 	Export Kit v1.3.figma
	 *
	 */
class log_in_activity : AppCompatActivity() {
    companion object{
        lateinit var auth: FirebaseAuth
        private lateinit var googleSignInClient:GoogleSignInClient
    }
    lateinit var enterusername : EditText
    lateinit var enterpassword : EditText
    private var _bg___3___a___log_in: View? = null
    private var rectangle_146: View? = null
    private var rectangle_145: View? = null
    private var rectangle_17: View? = null

    private val vector: ImageView? = null
    private val vector_ek1: ImageView? = null
    private val vector__stroke_: ImageView? = null
    private val vector__stroke__ek1: ImageView? = null
    private var example_example_com: TextView? = null
    private var rectangle_16: View? = null
    private var username_or_email: TextView? = null
    private var password: TextView? = null
    private var forgot_password_: TextView? = null
    private var gmail_ek1: ImageView? = null
    private val mark_ek1: ImageView? = null
    private var vector_ek2: ImageView? = null
    private var rectangle_146_ek1: View? = null
    private lateinit var google_button: RelativeLayout
    private lateinit var facebook_icon: RelativeLayout
    private var dsign_up:TextView?=null
    private var rectangle_145_ek1: View? = null
    private var log_in: TextView? = null
    private var vector_ek3: ImageView? = null
    private var log_in_ek1: TextView? = null
    private var welcome: TextView? = null
    private var don_t_have_an_account__sign_up: TextView? = null
    private var or_sign_up_with: TextView? = null
    private var lorem_ipsum_dolor_sit_amet__consectetur_adipiscing_elit__sed_do_eiusmod_tempor_incididunt_ut_labore_et_dolore_magna_aliqua_: TextView? =
        null

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.log_in)
        auth = FirebaseAuth.getInstance()
        _bg___3___a___log_in = findViewById(R.id._bg___3___a___log_in) as View
        rectangle_146 = findViewById(R.id.rectangle_146) as View
        dsign_up=findViewById(R.id.dsign_up)
        rectangle_145 = findViewById(R.id.rectangle_145) as View
        rectangle_17 = findViewById(R.id.rectangle_17) as View
        rectangle_16 = findViewById(R.id.rectangle_16) as View
        username_or_email = findViewById<View>(R.id.username_or_email) as TextView
        password = findViewById<View>(R.id.password) as TextView
        forgot_password_ = findViewById<View>(R.id.forgot_password_) as TextView
        gmail_ek1 = findViewById<View>(R.id.gmail_ek1) as ImageView
        vector_ek2 = findViewById<View>(R.id.vector_ek2) as ImageView
        rectangle_146_ek1 = findViewById(R.id.rectangle_146_ek1) as View
        rectangle_145_ek1 = findViewById(R.id.rectangle_145_ek1) as View
        google_button = findViewById<RelativeLayout>(R.id.google_icon)
        facebook_icon = findViewById<RelativeLayout>(R.id.facebook_icon)
        log_in = findViewById<View>(R.id.log_in) as TextView
        vector_ek3 = findViewById<View>(R.id.vector_ek3) as ImageView
        log_in_ek1 = findViewById<View>(R.id.log_in_ek1) as TextView
        welcome = findViewById<View>(R.id.welcome) as TextView
        don_t_have_an_account__sign_up =
            findViewById<View>(R.id.don_t_have_an_account__sign_up) as TextView
        or_sign_up_with = findViewById<View>(R.id.or_sign_up_with) as TextView
        lorem_ipsum_dolor_sit_amet__consectetur_adipiscing_elit__sed_do_eiusmod_tempor_incididunt_ut_labore_et_dolore_magna_aliqua_ =
            findViewById<View>(R.id.lorem_ipsum_dolor_sit_amet__consectetur_adipiscing_elit__sed_do_eiusmod_tempor_incididunt_ut_labore_et_dolore_magna_aliqua_) as TextView
        enterusername=findViewById(R.id.enterusername)
        enterpassword=findViewById(R.id.enterpassword)
        val gso=GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("754218514491-f815achjhuo2lusedm1nsj66nev08ulf.apps.googleusercontent.com")
            .requestEmail()
            .build()
        googleSignInClient=GoogleSignIn.getClient(this,gso)
        google_button?.setOnClickListener()
        {
            googleSignInClient.signOut()
            val intent = googleSignInClient.signInIntent
            getResult.launch(intent)
        }

        dsign_up?.setOnClickListener()
        {
            val intent = Intent(this, sign_up_activity::class.java)
            startActivity(intent)
            finish()
        }
        vector_ek3?.setOnClickListener()
        {
            val intent = Intent(this, sign_up_activity::class.java)
            startActivity(intent)
            finish()
        }
        forgot_password_?.setOnClickListener()
        {
            val intent = Intent(this, forgotten_password__activity::class.java)
            startActivity(intent)
        }
        rectangle_145_ek1?.setOnClickListener(){
            if (!isValidEmail(enterusername.text.toString())) {
                Toast.makeText(this, "Enter a valid email address", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
             if(enterusername.text.toString().isEmpty()||enterpassword.text.toString().isEmpty())
        {
            Toast.makeText(this,"Enter all details", Toast.LENGTH_SHORT).show()
        }
            else
             {
                 val emaill=enterusername.text.toString()
                 val passs=enterpassword.text.toString()
                 sign_up_activity.auth.signInWithEmailAndPassword(emaill,passs).addOnCompleteListener(){
                     if(it.isSuccessful)
                     {
                         Toast.makeText(this,"Log in Successful",Toast.LENGTH_LONG).show()

                         val intent = Intent(this,STEPS::class.java)
                         startActivity(intent)
                     }
                 }.addOnFailureListener(){
                     Toast.makeText(this,it.localizedMessage,Toast.LENGTH_LONG).show()
                 }
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
                Toast.makeText(this,"Login Successful",Toast.LENGTH_SHORT).show()
                val intent = Intent(this, STEPS::class.java)
                startActivity(intent)
                finish()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Authentication Failed: ${it.message}", Toast.LENGTH_SHORT).show()
            }
    }
    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }



}

