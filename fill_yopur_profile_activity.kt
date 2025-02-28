package com.example.pogo

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class fill_yopur_profile_activity : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    lateinit var profile_image: ImageView
    lateinit var madison_smith: EditText
    lateinit var madison: EditText
    lateinit var email: EditText
    lateinit var mobile_number: EditText
    lateinit var filter_button: TextView
    lateinit var back: TextView
    lateinit var vector_ek3: ImageView

    lateinit var videoLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.fill_yopur_profile)

        // Initialize Firebase database reference
        database = FirebaseDatabase.getInstance().reference

        // Initialize views
        profile_image = findViewById(R.id.profile_image)
        madison_smith = findViewById(R.id.madison_smith)
        madison = findViewById(R.id.madison)
        email = findViewById(R.id.madisons_example_com)
        mobile_number = findViewById(R.id.numberr)
        filter_button = findViewById(R.id.filter_button)
        back = findViewById(R.id.back)
        vector_ek3 = findViewById(R.id.vector_ek3)

        // Set up videoLauncher for image selection
        videoLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK && result.data != null) {
                val selectedImageUri: Uri? = result.data?.data
                if (selectedImageUri != null) {
                    profile_image.setImageURI(selectedImageUri) // Set the selected image as profile picture
                }
            }
        }

        // Back button listener
        back.setOnClickListener {
            val intent = Intent(this@fill_yopur_profile_activity, HeightActivity::class.java)
            startActivity(intent)
        }

        // Open image picker on image view click
        vector_ek3.setOnClickListener {
            openImagePicker()
        }

        // Save user profile when filter button is clicked
        filter_button.setOnClickListener {
            saveProfileData() // Save data to SharedPreferences
            val userId = saveUserProfile() // Save user profile to Firebase and get the userId
            if (userId != null) {
                val intent = Intent(this@fill_yopur_profile_activity, myprofile::class.java)
                intent.putExtra("USER_ID", userId)
                startActivity(intent)
            }
        }
    }

    private fun openImagePicker() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.type = "image/*"
        videoLauncher.launch(intent)
    }

    private fun saveProfileData() {
        val sharedPreferences = getSharedPreferences("UserProfile", MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.putString("FULL_NAME", madison_smith.text.toString())
        editor.putString("NICKNAME", madison.text.toString())
        editor.putString("USER_EMAIL", email.text.toString())
        editor.putString("MOBILE_NUMBER", mobile_number.text.toString())

        editor.apply()
    }

    private fun saveUserProfile(): String? {
        // Get values from EditText fields
        val fullName = madison_smith.text.toString()
        val nickname = madison.text.toString()
        val userEmail = email.text.toString()
        val mobileNumber = mobile_number.text.toString()

        // Create a unique key for the user profile
        val userId = database.push().key

        // Create User object
        val user = User(fullName, nickname, userEmail, mobileNumber)

        // Save the data in Firebase Realtime Database
        if (userId != null) {
            database.child("users").child(userId).setValue(user).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Profile saved successfully!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Failed to save profile!", Toast.LENGTH_SHORT).show()
                }
            }
        }
        return userId // Return the userId to pass to the next activity
    }

    // User data class
    data class User(
        val fullName: String,
        val nickname: String,
        val email: String,
        val mobileNumber: String
    )
}
