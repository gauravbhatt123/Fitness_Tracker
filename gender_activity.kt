package com.example.pogo

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/*
 *  This content is generated from the API File Info.
 *  (Alt+Shift+Ctrl+I).
 *
 *  @desc
 *  @file        4_1___a___gender
 *  @date        Monday 06th of January 2025 05:45:08 PM
 *  @title       Page 1
 *  @author
 *  @keywords
 *  @generator   Export Kit v1.3.figma
 *
 */
class gender_activity : Activity() {
    private var _bg___4_1___a___gender: View? = null
    private var rectangle_146: View? = null
    private var rectangle_145: View? = null
    private var continue1: TextView? = null
    private var vector: ImageView? = null
    private var what_s_your_gender: TextView? = null
    private var rectangle_14: View? = null
    private var lorem_ipsum_dolor_sit_amet__consectetur_adipiscing_elit__sed_do_eiusmod_tempor_incididunt_ut_labore_et_dolore_magna_aliqua_: TextView? = null
    private var male: TextView? = null
    private var female: TextView? = null
    private var back: TextView? = null
    private var rectangle_146_ek1: View? = null
    private var rectangle_145_ek1: View? = null
    private var vector_ek1: ImageView? = null
    private var ellipse_167: View? = null
    private var vector_ek2: ImageView? = null

    private var selectedGender: String? = null  // Variable to store gender choice

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gender)

        _bg___4_1___a___gender = findViewById(R.id._bg___4_1___a___gender) as View
        rectangle_146 = findViewById(R.id.rectangle_146) as View
        rectangle_145 = findViewById(R.id.rectangle_145) as View
        continue1 = findViewById<View>(R.id.continue1) as TextView
        vector = findViewById<View>(R.id.vector) as ImageView
        what_s_your_gender = findViewById<View>(R.id.what_s_your_gender) as TextView
        rectangle_14 = findViewById(R.id.rectangle_14) as View
        lorem_ipsum_dolor_sit_amet__consectetur_adipiscing_elit__sed_do_eiusmod_tempor_incididunt_ut_labore_et_dolore_magna_aliqua_ = findViewById<View>(R.id.lorem_ipsum_dolor_sit_amet__consectetur_adipiscing_elit__sed_do_eiusmod_tempor_incididunt_ut_labore_et_dolore_magna_aliqua_) as TextView
        male = findViewById<View>(R.id.male) as TextView
        female = findViewById<View>(R.id.female) as TextView
        back = findViewById(R.id.back) as TextView
        rectangle_146_ek1 = findViewById(R.id.rectangle_146_ek1) as View
        vector_ek1 = findViewById<View>(R.id.vector_ek1) as ImageView
        ellipse_167 = findViewById(R.id.ellipse_167) as View
        vector_ek2 = findViewById<View>(R.id.vector_ek2) as ImageView

        // Set OnClickListener for the back button
        back?.setOnClickListener {
            val intent = Intent(this@gender_activity, Ageinput::class.java)
            startActivity(intent)
        }

        // Set OnClickListener for rectangle_146_ek1 (Male option)
        rectangle_146_ek1?.setOnClickListener {
            selectedGender = "Male"
            Toast.makeText(this, "Selected Gender: Male", Toast.LENGTH_SHORT).show()
        }

        // Set OnClickListener for ellipse_167 (Female option)
        ellipse_167?.setOnClickListener {
            selectedGender = "Female"
            Toast.makeText(this, "Selected Gender: Female", Toast.LENGTH_SHORT).show()
        }
        rectangle_145?.setOnClickListener{
            val intent = Intent(this@gender_activity, WeightActivity::class.java)
            startActivity(intent)
        }
    }
}
