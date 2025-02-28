package com.example.pogo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.TextView

/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		splash
	 *	@date 		Saturday 04th of January 2025 08:29:38 AM
	 *	@title 		Page 1
	 *	@author 	
	 *	@keywords 	
	 *	@generator 	Export Kit v1.3.figma
	 *
	 */
class splash_activity : Activity() {
    private var _bg__splash: View? = null
    private var beautiful_young_sporty_woman_training_workout_gym_3: ImageView? = null
    private var rectangle_162: ImageView? = null
    private var welcome_to: TextView? = null
    private var vector: ImageView? = null
    private var vector_ek1: ImageView? = null
    private var vector_ek2: ImageView? = null
    private var vector_ek3: ImageView? = null
    private var vector_ek4: ImageView? = null
    private var vector_ek5: ImageView? = null
    private var vector_ek6: ImageView? = null
    private var fitbody: TextView? = null
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)
        _bg__splash = findViewById(R.id._bg__splash) as View
        beautiful_young_sporty_woman_training_workout_gym_3 =
            findViewById<View>(R.id.beautiful_young_sporty_woman_training_workout_gym_3) as ImageView
        rectangle_162 = findViewById<View>(R.id.rectangle_162) as ImageView
        welcome_to = findViewById<View>(R.id.welcome_to) as TextView
        vector = findViewById<View>(R.id.vector) as ImageView
        vector_ek1 = findViewById<View>(R.id.vector_ek1) as ImageView
        vector_ek2 = findViewById<View>(R.id.vector_ek2) as ImageView
        vector_ek3 = findViewById<View>(R.id.vector_ek3) as ImageView
        vector_ek4 = findViewById<View>(R.id.vector_ek4) as ImageView
        vector_ek5 = findViewById<View>(R.id.vector_ek5) as ImageView
        vector_ek6 = findViewById<View>(R.id.vector_ek6) as ImageView
        fitbody = findViewById<View>(R.id.fitbody) as TextView

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@splash_activity, first_activity::class.java)
            startActivity(intent)
            finish() // Close SplashActivity so it's not in the back stack
        },  4000)
        //custom code goes here
    }
}
