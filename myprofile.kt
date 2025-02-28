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
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class myprofile : AppCompatActivity() {

    private var _bg___4_7___a___fill_yopur_profile: View? = null
    private var rectangle_14: View? = null
    lateinit var profile_image: ImageView
    private var vector: ImageView? = null
    private var vector_ek1: ImageView? = null
    private var vector__stroke_: ImageView? = null
    private var vector__stroke__ek1: ImageView? = null
    private var start: TextView? = null
    private var vector_ek2: ImageView? = null
    private var fill_your_profile: TextView? = null
    private var lorem_ipsum_dolor_sit_amet__consectetur_adipiscing_elit__sed_do_eiusmod_tempor_incididunt_ut_labore_et_dolore_magna_aliqua_: TextView? = null
    private var back: TextView? = null
    private var alejandrao_a_woman_confidently_deadlifting_a_barbell_loaded_w_9167964a_d00b_41ab_b715_9b001ca0ca09_1_1: ImageView? = null
    private var rectangle_135: View? = null
    lateinit var videoLauncher: ActivityResultLauncher<Intent>
    private var rectangle_156: View? = null
    private var rectangle_157: View? = null
    private var rectangle_158: View? = null
    lateinit var madisons_example_com: EditText
    lateinit var numberr: EditText
    lateinit var madison_smith: EditText
    lateinit var madison: EditText
    private var full_name: TextView? = null
    private var nickname: TextView? = null
    private var email: TextView? = null
    private var mobile_number: EditText? = null
    private var ellipse_12: View? = null
    private var vector_ek3: ImageView? = null
    private var filter_button: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.myprofile)

        // Initialize views
        _bg___4_7___a___fill_yopur_profile = findViewById(R.id._bg___4_7___a___fill_yopur_profile)
        rectangle_14 = findViewById(R.id.rectangle_14)
        profile_image = findViewById(R.id.profile_image)
        videoLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK && result.data != null) {
                val selectedImageUri: Uri? = result.data?.data
                if (selectedImageUri != null) {
                    profile_image.setImageURI(selectedImageUri) // Set the selected image as profile picture
                }
            }
        }

        // Initialize EditText and set the values from SharedPreferences
        madisons_example_com = findViewById(R.id.madisons_example_com)
        numberr = findViewById(R.id.numberr)
        madison_smith = findViewById(R.id.madison_smith)
        madison = findViewById(R.id.madison)

        // Load saved data
        loadProfileData()

        // Set up back button listener
        back = findViewById(R.id.back)
        back?.setOnClickListener {
            val intent = Intent(this@myprofile, STEPS::class.java)
            startActivity(intent)
        }

        // Set up image picker for profile image
        vector_ek3 = findViewById(R.id.vector_ek3)
        vector_ek3?.setOnClickListener {
            openImagePicker()
        }

        // Set up vector click for navigating to previous screen
        val vector_ek14 = findViewById<ImageView>(R.id.vector_ek14)
        vector_ek14?.setOnClickListener {
            val intent = Intent(this@myprofile, STEPS::class.java)
            startActivity(intent)
        }

        val vector_ek15 = findViewById<ImageView>(R.id.vector_ek15)
        vector_ek15?.setOnClickListener {
            val intent = Intent(this@myprofile, home_activity::class.java)
            startActivity(intent)
        }
    }

    private fun loadProfileData() {
        val sharedPreferences = getSharedPreferences("UserProfile", MODE_PRIVATE)

        val fullName = sharedPreferences.getString("FULL_NAME", "")
        val nickname = sharedPreferences.getString("NICKNAME", "")
        val userEmail = sharedPreferences.getString("USER_EMAIL", "")
        val mobileNumber = sharedPreferences.getString("MOBILE_NUMBER", "")

        // Set the retrieved values to the EditTexts
        madison_smith.setText(fullName)
        madison.setText(nickname)
        madisons_example_com.setText(userEmail)
        numberr.setText(mobileNumber)
    }

    private fun openImagePicker() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.type = "image/*"
        videoLauncher.launch(intent)
    }
}
