package com.example.pogo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		third
	 *	@date 		Saturday 04th of January 2025 04:37:34 AM
	 *	@title 		Page 1
	 *	@author 	
	 *	@keywords 	
	 *	@generator 	Export Kit v1.3.figma
	 *
	 */
class third_activity : Activity() {
    private var _bg__third: View? = null
    private var beautiful_young_sporty_woman_training_workout_gym_3: ImageView? = null
    private var rectangle_162: ImageView? = null
    private var rectangle_146: View? = null
    private var rectangle_145: View? = null
    private var a_community_for_you__challenge_yourself: TextView? = null
    private var rectangle_146_ek1: View? = null
    private var rectangle_145_ek1: View? = null
    private var get_started: TextView? = null
    private var rectangle_108: View? = null
    private var rectangle_109: View? = null
    private var rectangle_112: View? = null
    private var vector: ImageView? = null
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third)
        _bg__third = findViewById(R.id._bg__third) as View
        beautiful_young_sporty_woman_training_workout_gym_3 =
            findViewById<View>(R.id.beautiful_young_sporty_woman_training_workout_gym_3) as ImageView
        rectangle_162 = findViewById<View>(R.id.rectangle_162) as ImageView
        rectangle_146 = findViewById(R.id.rectangle_146) as View
        rectangle_145 = findViewById(R.id.rectangle_145) as View
        a_community_for_you__challenge_yourself =
            findViewById<View>(R.id.a_community_for_you__challenge_yourself) as TextView
        rectangle_146_ek1 = findViewById(R.id.rectangle_146_ek1) as View
        rectangle_145_ek1 = findViewById(R.id.rectangle_145_ek1) as View
        get_started = findViewById<View>(R.id.get_started) as TextView
        rectangle_108 = findViewById(R.id.rectangle_108) as View
        rectangle_109 = findViewById(R.id.rectangle_109) as View
        rectangle_112 = findViewById(R.id.rectangle_112) as View
        vector = findViewById<View>(R.id.vector) as ImageView
        rectangle_145_ek1?.setOnClickListener {
            // Navigate to third_activity
            val intent = Intent(this, sign_up_activity::class.java)
            startActivity(intent)
            finish()
        }

        //custom code goes here
    }
}
