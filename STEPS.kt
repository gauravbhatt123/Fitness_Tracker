package com.example.pogo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mikhaellopez.circularprogressbar.CircularProgressBar
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.widget.ImageView
import java.text.SimpleDateFormat
import java.util.*

class STEPS : AppCompatActivity(), SensorEventListener {

    private lateinit var progressCircular: CircularProgressBar
    private lateinit var tvStepsTaken: TextView
    private lateinit var tvPreviousDaySteps: TextView
    private lateinit var goalInput: EditText
    private lateinit var setGoalButton: Button
    private var stepGoal = 10000f
    private var stepsTaken = 0f // Variable to track steps taken
    private lateinit var sharedPreferences: SharedPreferences

    private lateinit var sensorManager: SensorManager
    private var accelerometer: Sensor? = null

    private var lastZ: Float = 0f
    private var isStepDetected = false

    private val threshold = 2.0f
    private val smoothingFactor = 0.9f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_steps)

        progressCircular = findViewById(R.id.circularProgressBar)
        tvStepsTaken = findViewById(R.id.tv_stepsTaken)
        tvPreviousDaySteps = findViewById(R.id.tv_previousDaySteps) // TextView to show previous day's steps
        goalInput = findViewById(R.id.goalInput)
        setGoalButton = findViewById(R.id.setGoalButton)
        val vector_ek15=findViewById<ImageView>(R.id.vector_ek15)
        vector_ek15?.setOnClickListener() {
            val intent = Intent(this@STEPS, home_activity::class.java)
            startActivity(intent)
        }
        val vector_ek17=findViewById<ImageView>(R.id.vector_ek17)
        vector_ek17?.setOnClickListener() {
            val intent = Intent(this@STEPS, myprofile::class.java)
            startActivity(intent)
        }

        // Initialize SharedPreferences to store the steps
        sharedPreferences = getSharedPreferences("StepTracker", MODE_PRIVATE)

        // Load the previous day's steps
        loadPreviousDaySteps()

        // Other UI and sensor initialization code...

        setGoalButton.setOnClickListener {
            val goalText = goalInput.text.toString()
            if (goalText.isNotEmpty()) {
                stepGoal = goalText.toFloat()
                updateProgressBar()
            } else {
                Toast.makeText(this, "Please enter a valid goal", Toast.LENGTH_SHORT).show()
            }
        }

        // Handle reset button click
        val resetButton: Button = findViewById(R.id.resetButton)
        resetButton.setOnClickListener {
            stepsTaken = 0f
            updateProgressBar()
            Toast.makeText(this, "Steps reset", Toast.LENGTH_SHORT).show()
        }

        // Initialize sensor manager and register listener
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        // Register the sensor listener
        accelerometer?.also { acc ->
            sensorManager.registerListener(this, acc, SensorManager.SENSOR_DELAY_UI)
        }

        updateProgressBar()
    }


    override fun onSensorChanged(event: SensorEvent?) {
        if (event == null) return

        // Step detection logic
        val z = event.values[2]
        val smoothedZ = smoothingFactor * lastZ + (1 - smoothingFactor) * z
        val deltaZ = smoothedZ - lastZ

        if (Math.abs(deltaZ) > threshold) {
            if (!isStepDetected) {
                stepsTaken++
                updateProgressBar()
                isStepDetected = true
            }
        } else {
            if (Math.abs(deltaZ) < 0.2f) {
                isStepDetected = false
            }
        }

        lastZ = smoothedZ
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}

    private fun updateProgressBar() {
        progressCircular.progressMax = stepGoal
        progressCircular.progress = stepsTaken
        progressCircular.setProgressWithAnimation(stepsTaken, 1000)

        progressCircular.apply {
            progressBarColor = Color.parseColor("#FF4081")
            backgroundProgressBarColor = Color.parseColor("#E0E0E0")
            progressBarWidth = 20f
            backgroundProgressBarWidth = 10f
        }

        tvStepsTaken.text = "Steps: $stepsTaken / Goal: $stepGoal"
    }

    private fun loadPreviousDaySteps() {
        // Get the current date
        val currentDate = getCurrentDate()

        // Get the stored date and steps from SharedPreferences
        val storedDate = sharedPreferences.getString("last_date", "")
        val storedSteps = sharedPreferences.getFloat("steps_$storedDate", 0f)

        // If the stored date is different from the current date, save the steps for the previous day
        if (storedDate != currentDate) {
            // Save the steps for the previous day
            val editor = sharedPreferences.edit()
            val prevDay = Calendar.getInstance()
            prevDay.add(Calendar.DATE, -1) // Get the previous day
            val prevDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(prevDay.time)
            editor.putFloat("steps_$prevDate", stepsTaken)
            editor.putString("last_date", currentDate)
            editor.apply()

            // Update the previous day's steps in the UI
            tvPreviousDaySteps.text = "Previous Day's Steps: $storedSteps"
        }
    }

    private fun getCurrentDate(): String {
        // Get the current date in "yyyy-MM-dd" format
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return sdf.format(Date())
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onResume() {
        super.onResume()
        accelerometer?.also { acc ->
            sensorManager.registerListener(this, acc, SensorManager.SENSOR_DELAY_UI)
        }
    }
}
