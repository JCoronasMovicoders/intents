package com.example.intentsnavigation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_d.*

class ActivityD : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_d)

        btnBackB.setOnClickListener {
            if (ptActD.text.isNotEmpty()) {
                val intentSendDataToB = Intent(this, ActivityB::class.java)
                intentSendDataToB.putExtra("data", ptActD.text.toString())
                startActivity(intentSendDataToB)
            }
            else {
                Toast.makeText(applicationContext, "Write something...", Toast.LENGTH_SHORT).show()
            }

        }

    }
}