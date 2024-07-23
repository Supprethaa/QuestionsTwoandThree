package com.example.questionstwoandthree

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val tvMessage: TextView = findViewById(R.id.tvMessage)
        val tvCategory: TextView = findViewById(R.id.tvCategory)
        val btnGoBack: Button = findViewById(R.id.btnGoBack)

        // Retrieve the message and category sent from MainActivity
        val message = intent.getStringExtra("EXTRA_MESSAGE")
        val category = intent.getStringExtra("EXTRA_CATEGORY")
        tvMessage.text = message
        tvCategory.text = category

        btnGoBack.setOnClickListener {
            // Intent to go back to MainActivity
            val mainActivityIntent = Intent(this, MainActivity::class.java)
            startActivity(mainActivityIntent)
            finish() // Finish the current activity
        }
    }
}