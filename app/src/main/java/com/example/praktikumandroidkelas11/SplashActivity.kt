package com.example.praktikumandroidkelas11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import  android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            val i = Intent(this,StudentActivity::class.java)
            startActivity(i)
        }, 3000)

        supportActionBar?.hide()
    }
}
