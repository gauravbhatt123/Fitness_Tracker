package com.example.pogo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.abs

class WeightActivity : AppCompatActivity() {
    private lateinit var tvSelectedWeight: TextView
    private lateinit var rvWeightPicker: RecyclerView
    private lateinit var btnContinue: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weight)
        val tvBack=findViewById<TextView>(R.id.tvBack)

        tvBack.setOnClickListener{
            val intent = Intent(this@WeightActivity, Ageinput::class.java)
            startActivity(intent)
        }

       rvWeightPicker = findViewById<RecyclerView>(R.id.rvWeightPicker)
         tvSelectedWeight = findViewById<TextView>(R.id.tvSelectedWeight)
       btnContinue = findViewById(R.id.btnContinue)

        // Initialize weights (e.g., from 30kg to 150kg)
        val weights = (30..150).toList()
        var selectedWeight = 70  // Default weight (you can change this)

        // Set up RecyclerView
        rvWeightPicker.adapter = AgeWeightAdapter(weights) { weight ->
            selectedWeight = weight
            tvSelectedWeight.text = weight.toString()
        }

        rvWeightPicker.layoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

        // SnapHelper for smooth scrolling and snapping to the center
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(rvWeightPicker)

        // Handle snapping effect (update the selected weight when scrolling stops)
        rvWeightPicker.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    val centerView = findCenterView(rvWeightPicker.layoutManager as LinearLayoutManager)
                    val position = rvWeightPicker.getChildAdapterPosition(centerView!!)
                    selectedWeight = weights[position]
                    tvSelectedWeight.text = selectedWeight.toString()
                }
            }
        })

        // Handle Continue button
        btnContinue.setOnClickListener {
            Toast.makeText(this, "Your weight is $selectedWeight", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@WeightActivity, HeightActivity::class.java)
            startActivity(intent)
            // Save the weight (you can store it or pass it to another activity)
        }
    }

    private fun findCenterView(layoutManager: LinearLayoutManager): View? {
        val centerX = rvWeightPicker.width / 2
        var minDistance = Int.MAX_VALUE
        var closestChild: View? = null
        for (i in 0 until rvWeightPicker.childCount) {
            val child = rvWeightPicker.getChildAt(i)
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
