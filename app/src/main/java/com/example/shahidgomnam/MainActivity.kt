package com.example.shahidgomnam

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.TextView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val text = TextView(this)

        text.text = "ما و شهید گمنام"
        text.textSize = 30f
        text.setTextColor(Color.WHITE)
        text.setBackgroundColor(Color.rgb(24, 37, 30))
        text.gravity = Gravity.CENTER

        setContentView(text)
    }
}
