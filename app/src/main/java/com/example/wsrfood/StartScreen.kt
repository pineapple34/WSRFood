package com.example.wsrfood

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class StartScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_screen)


    }

    fun startClick(view: View) {
        startActivity(Intent(this, LoginScreen::class.java))
    }
}