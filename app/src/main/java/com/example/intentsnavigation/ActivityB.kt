package com.example.intentsnavigation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_b.*

class ActivityB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
        tvData.isVisible = false

        btnBackA.setOnClickListener {
            startActivity(Intent(this, ActivityA::class.java))
        }

        btnBNextD.setOnClickListener {
            startActivity(Intent(this, ActivityD::class.java))
        }
    }

    override fun onResume () {
        super.onResume()
        val startingIntent = intent
        if (startingIntent.extras != null) {
            val data = intent.getStringExtra("data")
            tvData.isVisible = true
            tvData.text = data

        }
    }
}