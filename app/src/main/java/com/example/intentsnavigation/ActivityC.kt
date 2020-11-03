package com.example.intentsnavigation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_c.*

class ActivityC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        setContentView(R.layout.activity_c)

        btnActCToA.setOnClickListener {
            startActivity(Intent(this, ActivityA::class.java))
        }

        btnActCCall.setOnClickListener {
            if (etCall.length() != 0 ) {
                val callPhone = Intent(Intent.ACTION_DIAL)
                callPhone.data = Uri.parse("tel:${etCall.text}")
                startActivity(callPhone)
            } else {
                Toast.makeText(applicationContext, "Write something...", Toast.LENGTH_SHORT).show()
            }

        }

        btnActCMail.setOnClickListener {
            if (etMail.text.toString().trim().matches(emailPattern.toRegex())) {
                val sendEmail = Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto", etMail.text.toString(), null))
                startActivity(Intent(sendEmail))
            } else {
                Toast.makeText(applicationContext, "Invalid email address", Toast.LENGTH_SHORT).show()
            }
        }
    }
}