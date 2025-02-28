package com.example.pogo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class home_activity : Activity() {
    private var _bg___5___a___home: View? = null
    private var woman_helping_man_gym__1__5: ImageView? = null
    private var woman_helping_man_gym__1__6: ImageView? = null
    private var rectangle_14: View? = null

    private var vector: ImageView? = null
    private var vector_ek1: ImageView? = null
    private var vector__stroke_: ImageView? = null
    private var vector__stroke__ek1: ImageView? = null
    private var hi__madison: TextView? = null
    private var it_s_time_to_challenge_your_limits_: TextView? = null
    private var squat_exercise: TextView? = null
    private var full_body_stretching: TextView? = null
    private var recommendations: TextView? = null
    private var see_all: TextView? = null
    private var rectangle_6: View? = null
    private var rectangle_11: View? = null
    private var rectangle_10: View? = null
    private var weekly_challenge: TextView? = null
    private var articles___tips: TextView? = null
    private var supplement_guide___: TextView? = null
    private var quick___effective_daily_routines___: TextView? = null
    private var plank_with_hip_twist: TextView? = null
    private var vector_ek2: ImageView? = null
    private var vector_ek3: ImageView? = null
    private var vector_ek4: ImageView? = null
    private var vector_ek5: ImageView? = null
    private var ellipse_47: View? = null
    private var vector_ek6: ImageView? = null
    private var vector_ek7: ImageView? = null
    private var minutes: TextView? = null
    private var kcal: TextView? = null
    private var vector_ek8: ImageView? = null
    private var vector_ek9: ImageView? = null
    private var minutes_ek1: TextView? = null
    private var kcal_ek1: TextView? = null
    private var vector_ek10: ImageView? = null
    private var vector_ek11: ImageView? = null
    private var woman_helping_man_gym__1__2: ImageView? = null
    private var woman_helping_man_gym__1__3: ImageView? = null
    private var woman_helping_man_gym__1__4: ImageView? = null
    private var ellipse_36: View? = null
    private var vector_ek12: ImageView? = null
    private var ellipse_36_ek1: View? = null
    private var vector_ek13: ImageView? = null
    private var line_3: ImageView? = null
    private var rectangle_10_ek1: View? = null
    private var vector_ek14: ImageView? = null
    private var vector_ek15: ImageView? = null
    private var vector_ek16: ImageView? = null
    private var vector_ek17: ImageView? = null
    private var vector_ek18: ImageView? = null
    private var workout: TextView? = null
    private var vector_161: ImageView? = null
    private var vector_ek19: ImageView? = null
    private var progress_tracking: TextView? = null
    private var vector_162: ImageView? = null
    private var vector_ek20: ImageView? = null
    private var nutrition: TextView? = null
    private var vector_163: ImageView? = null
    private var vector_ek21: ImageView? = null
    private var community: TextView? = null
    private var vector_ek22: ImageView? = null
    private var vector_ek23: ImageView? = null
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)
        _bg___5___a___home = findViewById(R.id._bg___5___a___home) as View
        woman_helping_man_gym__1__5 =
            findViewById<View>(R.id.woman_helping_man_gym__1__5) as ImageView
        woman_helping_man_gym__1__6 =
            findViewById<View>(R.id.woman_helping_man_gym__1__6) as ImageView
        rectangle_14 = findViewById(R.id.rectangle_14) as View

        hi__madison = findViewById<View>(R.id.hi__madison) as TextView
        it_s_time_to_challenge_your_limits_ =
            findViewById<View>(R.id.it_s_time_to_challenge_your_limits_) as TextView
        squat_exercise = findViewById<View>(R.id.squat_exercise) as TextView
        full_body_stretching = findViewById<View>(R.id.full_body_stretching) as TextView
        recommendations = findViewById<View>(R.id.recommendations) as TextView
        see_all = findViewById<View>(R.id.see_all) as TextView
        rectangle_6 = findViewById(R.id.rectangle_6) as View
        rectangle_11 = findViewById(R.id.rectangle_11) as View
        rectangle_10 = findViewById(R.id.rectangle_10) as View
        weekly_challenge = findViewById<View>(R.id.weekly_challenge) as TextView
        articles___tips = findViewById<View>(R.id.articles___tips) as TextView
        supplement_guide___ = findViewById<View>(R.id.supplement_guide___) as TextView
        quick___effective_daily_routines___ =
            findViewById<View>(R.id.quick___effective_daily_routines___) as TextView
        plank_with_hip_twist = findViewById<View>(R.id.plank_with_hip_twist) as TextView
        vector_ek2 = findViewById<View>(R.id.vector_ek2) as ImageView
        vector_ek3 = findViewById<View>(R.id.vector_ek3) as ImageView
        vector_ek4 = findViewById<View>(R.id.vector_ek4) as ImageView
        vector_ek5 = findViewById<View>(R.id.vector_ek5) as ImageView
        ellipse_47 = findViewById(R.id.ellipse_47) as View
        vector_ek6 = findViewById<View>(R.id.vector_ek6) as ImageView
        vector_ek7 = findViewById<View>(R.id.vector_ek7) as ImageView
        minutes = findViewById<View>(R.id.minutes) as TextView
        kcal = findViewById<View>(R.id.kcal) as TextView
        vector_ek8 = findViewById<View>(R.id.vector_ek8) as ImageView
        vector_ek9 = findViewById<View>(R.id.vector_ek9) as ImageView
        minutes_ek1 = findViewById<View>(R.id.minutes_ek1) as TextView
        kcal_ek1 = findViewById<View>(R.id.kcal_ek1) as TextView
        vector_ek10 = findViewById<View>(R.id.vector_ek10) as ImageView
        vector_ek11 = findViewById<View>(R.id.vector_ek11) as ImageView
        woman_helping_man_gym__1__2 =
            findViewById<View>(R.id.woman_helping_man_gym__1__2) as ImageView
        woman_helping_man_gym__1__3 =
            findViewById<View>(R.id.woman_helping_man_gym__1__3) as ImageView
        woman_helping_man_gym__1__4 =
            findViewById<View>(R.id.woman_helping_man_gym__1__4) as ImageView
        ellipse_36 = findViewById(R.id.ellipse_36) as View
        vector_ek12 = findViewById<View>(R.id.vector_ek12) as ImageView
        ellipse_36_ek1 = findViewById(R.id.ellipse_36_ek1) as View
        vector_ek13 = findViewById<View>(R.id.vector_ek13) as ImageView
        line_3 = findViewById<View>(R.id.line_3) as ImageView
        rectangle_10_ek1 = findViewById(R.id.rectangle_10_ek1) as View
        vector_ek14 = findViewById<View>(R.id.vector_ek14) as ImageView
        vector_ek14?.setOnClickListener{
            val intent = Intent(this@home_activity, STEPS::class.java)
            startActivity(intent)
        }
        vector_ek15 = findViewById<View>(R.id.vector_ek15) as ImageView

        vector_ek17 = findViewById<View>(R.id.vector_ek17) as ImageView
        vector_ek17?.setOnClickListener{
            val intent = Intent(this@home_activity, myprofile::class.java)
            startActivity(intent)
        }
        vector_ek18 = findViewById<View>(R.id.vector_ek18) as ImageView
        workout = findViewById<View>(R.id.workout) as TextView
        vector_161 = findViewById<View>(R.id.vector_161) as ImageView
        vector_ek19 = findViewById<View>(R.id.vector_ek19) as ImageView
        progress_tracking = findViewById<View>(R.id.progress_tracking) as TextView
        vector_162 = findViewById<View>(R.id.vector_162) as ImageView
        vector_ek20 = findViewById<View>(R.id.vector_ek20) as ImageView
        nutrition = findViewById<View>(R.id.nutrition) as TextView
        vector_163 = findViewById<View>(R.id.vector_163) as ImageView
        vector_ek21 = findViewById<View>(R.id.vector_ek21) as ImageView
        community = findViewById<View>(R.id.community) as TextView
        vector_ek22 = findViewById<View>(R.id.vector_ek22) as ImageView
        vector_ek23 = findViewById<View>(R.id.vector_ek23) as ImageView


        //custom code goes here
    }
}
