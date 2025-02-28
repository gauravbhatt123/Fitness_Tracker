package com.example.pogo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.abs

class Ageinput : AppCompatActivity() {

    private lateinit var tvSelectedAge: TextView
    private lateinit var rvAgeSelector: RecyclerView
    private lateinit var tvbutton:TextView
    private lateinit var btnContinue: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.age_input)

        tvSelectedAge = findViewById(R.id.tvSelectedAge)
        rvAgeSelector = findViewById(R.id.rvAgeSelector)
        btnContinue = findViewById(R.id.btnContinue)
        tvbutton=findViewById(R.id.tvBack)
        tvbutton.setOnClickListener{
            val intent = Intent(this@Ageinput, log_in_activity::class.java)
            startActivity(intent)
        }

        val ages = (0..100).toList() // Age range
        var selectedAge = 29

        val adapter = AgeAdapter(ages) { age ->
            selectedAge = age
            tvSelectedAge.text = age.toString()
        }

        rvAgeSelector.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvAgeSelector.adapter = adapter

        // Center the RecyclerView on the selected age
        rvAgeSelector.scrollToPosition(ages.indexOf(selectedAge))

        // Handle snapping effect
        rvAgeSelector.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    val centerView = findCenterView(rvAgeSelector.layoutManager as LinearLayoutManager)
                    val position = rvAgeSelector.getChildAdapterPosition(centerView!!)
                    selectedAge = ages[position]
                    tvSelectedAge.text = selectedAge.toString()
                }
            }
        })

        btnContinue.setOnClickListener {
            Toast.makeText(this, "Selected Age: $selectedAge", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@Ageinput, gender_activity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun findCenterView(layoutManager: LinearLayoutManager): View? {
        val centerX = rvAgeSelector.width / 2
        var minDistance = Int.MAX_VALUE
        var closestChild: View? = null
        for (i in 0 until rvAgeSelector.childCount) {
            val child = rvAgeSelector.getChildAt(i)
            val childCenterX = (child.left + child.right) / 2
            val distance = abs(centerX - childCenterX)
            if (distance < minDistance) {
                minDistance = distance
                closestChild = child
            }
        }
        return closestChild
    }
}
