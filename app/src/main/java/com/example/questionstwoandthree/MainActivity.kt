package com.example.questionstwoandthree


import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnOpenCalculator: Button = findViewById(R.id.btnOpenCalculator)
        val btnGoToSecondActivity: Button = findViewById(R.id.btnGoToSecondActivity)
        val spinnerCategory: Spinner = findViewById(R.id.spinnerCategory)

        // Populate the spinner with categories
        val categories = arrayOf("Personal", "Work", "Finance", "Other")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCategory.adapter = adapter

        btnOpenCalculator.setOnClickListener {
            // Intent to start the calculator app
            val calculatorIntent = packageManager.getLaunchIntentForPackage("com.example.calculator")
            if (calculatorIntent != null) {
                startActivity(calculatorIntent)
            }
        }

        btnGoToSecondActivity.setOnClickListener {
            // Intent to start the second activity and send data
            val secondActivityIntent = Intent(this, SecondActivity::class.java)
            secondActivityIntent.putExtra("EXTRA_MESSAGE", "Hello from MainActivity")
            val selectedCategory = spinnerCategory.selectedItem.toString()
            secondActivityIntent.putExtra("EXTRA_CATEGORY", selectedCategory)
            startActivity(secondActivityIntent)
        }
    }
}