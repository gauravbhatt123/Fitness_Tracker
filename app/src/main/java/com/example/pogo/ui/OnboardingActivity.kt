package com.example.pogo.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.pogo.R
import com.google.android.material.button.MaterialButton

/**
 * Onboarding activity using ViewPager2 — replaces the 3 separate first/second/third activities.
 * Shows 3 pages with smooth swipe transitions and animated page indicators.
 */
class OnboardingActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var btnNext: MaterialButton
    private lateinit var btnSkip: TextView
    private lateinit var dots: List<View>

    private val pages = listOf(
        OnboardingPage(
            "Track Your Workouts",
            "Start your journey towards a more active lifestyle with personalized fitness tracking."
        ),
        OnboardingPage(
            "Nutrition Tips",
            "Find nutrition tips that fit your lifestyle and help you reach your goals faster."
        ),
        OnboardingPage(
            "Join the Community",
            "A community for you. Challenge yourself with weekly goals and connect with others."
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        viewPager = findViewById(R.id.viewPager)
        btnNext = findViewById(R.id.btnNext)
        btnSkip = findViewById(R.id.btnSkip)
        dots = listOf(
            findViewById(R.id.dot1),
            findViewById(R.id.dot2),
            findViewById(R.id.dot3)
        )

        viewPager.adapter = OnboardingAdapter(pages)

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                updateDots(position)
                btnNext.text = if (position == pages.size - 1) {
                    getString(R.string.get_started)
                } else {
                    getString(R.string.next)
                }
                btnSkip.visibility = if (position == pages.size - 1) View.INVISIBLE else View.VISIBLE
            }
        })

        btnNext.setOnClickListener {
            if (viewPager.currentItem < pages.size - 1) {
                viewPager.currentItem += 1
            } else {
                navigateToSignUp()
            }
        }

        btnSkip.setOnClickListener {
            navigateToSignUp()
        }
    }

    private fun updateDots(position: Int) {
        dots.forEachIndexed { index, dot ->
            if (index == position) {
                dot.layoutParams.width = resources.getDimensionPixelSize(R.dimen.dot_active_width)
                dot.setBackgroundResource(R.drawable.bg_button_primary)
            } else {
                dot.layoutParams.width = resources.getDimensionPixelSize(R.dimen.dot_inactive_width)
                dot.setBackgroundResource(R.drawable.bg_circle_profile)
                dot.backgroundTintList = getColorStateList(R.color.dot_inactive)
            }
            dot.requestLayout()
        }
    }

    private fun navigateToSignUp() {
        startActivity(Intent(this, SignUpActivity::class.java))
        finish()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    /** Data class for onboarding page content */
    data class OnboardingPage(val title: String, val description: String)

    /** ViewPager2 adapter for onboarding pages */
    inner class OnboardingAdapter(
        private val pages: List<OnboardingPage>
    ) : RecyclerView.Adapter<OnboardingAdapter.PageViewHolder>() {

        inner class PageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val tvTitle: TextView = view.findViewById(R.id.tvTitle)
            val tvDescription: TextView = view.findViewById(R.id.tvDescription)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_onboarding_page, parent, false)
            return PageViewHolder(view)
        }

        override fun onBindViewHolder(holder: PageViewHolder, position: Int) {
            val page = pages[position]
            holder.tvTitle.text = page.title
            holder.tvDescription.text = page.description
        }

        override fun getItemCount(): Int = pages.size
    }
}
