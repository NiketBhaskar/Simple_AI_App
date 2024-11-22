package com.example.demoaiapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val eTPrompt = findViewById<EditText>(R.id.eTPrompt)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val tVResult = findViewById<TextView>(R.id.tVResult)

        btnSubmit.setOnClickListener{
            val prompt = eTPrompt.text.toString()

            val model = GenerativeModel("gemini-pro",
                "AIzaSyB4hQdTitsxbpk9pOWRlfNO5zSQ3zX5g8E")
            runBlocking {
                val response = model.generateContent(prompt)
                tVResult.text = response.text.toString()
            }
        }

    }
}