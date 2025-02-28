package com.example.pogo

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import eightbitlab.com.blurview.BlurView

/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		first
	 *	@date 		Saturday 04th of January 2025 04:30:50 AM
	 *	@title 		Page 1
	 *	@author 	
	 *	@keywords 	
	 *	@generator 	Export Kit v1.3.figma
	 *
	 */
class first_activity : Activity() {
    private var _bg__first: View? = null
    private var beautiful_young_sporty_woman_training_workout_gym_3: ImageView? = null
    private var rectangle_162: ImageView? = null
    private var rectangle_146: View? = null
    private var rectangle_145: View? = null
    private var vector: ImageView? = null
    private var start_your_journey_towards_a_more_active_lifestyle: TextView? = null
    private var rectangle_146_ek1: View? = null
    private var rectangle_145_ek1: View? = null
    private var next: TextView? = null
    private var rectangle_108: View? = null
    private var rectangle_109: View? = null
    private var rectangle_112: View? = null
    private var vector_ek1: ImageView? = null
    var radius=5f
    private var skip: TextView? = null
    lateinit var blurry:BlurView
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first)
        _bg__first = findViewById(R.id._bg__first) as View
        beautiful_young_sporty_woman_training_workout_gym_3 =
            findViewById<View>(R.id.beautiful_young_sporty_woman_training_workout_gym_3) as ImageView
        rectangle_162 = findViewById<View>(R.id.rectangle_162) as ImageView
        rectangle_146 = findViewById(R.id.rectangle_146) as View
        rectangle_145 = findViewById(R.id.rectangle_145) as View
        vector = findViewById<View>(R.id.vector) as ImageView
        start_your_journey_towards_a_more_active_lifestyle =
            findViewById<View>(R.id.start_your_journey_towards_a_more_active_lifestyle) as TextView

        next = findViewById<View>(R.id.next) as TextView
        rectangle_108 = findViewById(R.id.rectangle_108) as View
        rectangle_109 = findViewById(R.id.rectangle_109) as View
        rectangle_112 = findViewById(R.id.rectangle_112) as View
        vector_ek1 = findViewById<View>(R.id.vector_ek1) as ImageView
        rectangle_145_ek1=findViewById(R.id.rectangle_145_ek1) as View
        skip = findViewById<View>(R.id.skip) as TextView

        skip?.setOnClickListener {
            // Navigate to third_activity
            val intent = Intent(this, third_activity::class.java)
            startActivity(intent)
            finish()
        }
        rectangle_145_ek1?.setOnClickListener {
            // Navigate to third_activity
            val intent = Intent(this, second_activity::class.java)
            startActivity(intent)
            finish()
        }

        //custom code goes here
    }
}
