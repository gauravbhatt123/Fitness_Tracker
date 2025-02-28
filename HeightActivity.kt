package com.example.pogo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HeightActivity : AppCompatActivity() {
    private var selectedHeight = 165 // Default height
    private var backButton:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.height)
        backButton=findViewById(R.id.backButton)
        backButton?.setOnClickListener{
            val intent = Intent(this@HeightActivity, WeightActivity::class.java)
            startActivity(intent)
        }
        val heightText = findViewById<TextView>(R.id.heightText)
        val heightRecyclerView = findViewById<RecyclerView>(R.id.heightRecyclerView)
        val continueButton = findViewById<Button>(R.id.continueButton)

        // Heights list (150 to 200 cm)
        val heights = (150..200).toList()

        // Setup RecyclerView
        heightRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val adapter = HeightAdapter(heights) { height ->
            selectedHeight = height
            heightText.text = "$selectedHeight Cm"
        }
        heightRecyclerView.adapter = adapter

        // Scroll to default position (165 cm)
        heightRecyclerView.scrollToPosition(heights.indexOf(selectedHeight))

        // Add Scroll Listener
        heightRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    val centerPosition = (recyclerView.layoutManager as LinearLayoutManager)
                        .findFirstCompletelyVisibleItemPosition()
                    selectedHeight = heights[centerPosition]
                    heightText.text = "$selectedHeight Cm"
                }
            }
        })

        // Continue Button
        continueButton.setOnClickListener {
            // Store the height
            val heightValue = selectedHeight
            Toast.makeText(this, "Height Saved: $heightValue Cm", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@HeightActivity, fill_yopur_profile_activity::class.java)
            startActivity(intent)
        }
    }
}
