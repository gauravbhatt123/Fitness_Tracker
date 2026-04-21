package com.example.pogo.ui

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.example.pogo.R
import com.example.pogo.util.AuthManager

/**
 * Splash screen with animated entrance.
 * Auto-navigates to onboarding or home (if already logged in) after 2.5 seconds.
 */
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Animate logo and text entrance
        val logo = findViewById<View>(R.id.ivLogo)
        val welcomeText = findViewById<View>(R.id.tvWelcomeTo)
        val appName = findViewById<View>(R.id.tvAppName)

        logo.alpha = 0f
        welcomeText.alpha = 0f
        appName.alpha = 0f

        logo.animate().alpha(1f).translationY(0f).setDuration(800)
            .setInterpolator(AccelerateDecelerateInterpolator()).start()
        welcomeText.animate().alpha(1f).setStartDelay(400).setDuration(600).start()
        appName.animate().alpha(1f).setStartDelay(600).setDuration(600).start()

        Handler(Looper.getMainLooper()).postDelayed({
            val destination = if (AuthManager.isLoggedIn()) {
                HomeActivity::class.java
            } else {
                OnboardingActivity::class.java
            }
            startActivity(Intent(this, destination))
            finish()
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }, 2500)
    }
}
