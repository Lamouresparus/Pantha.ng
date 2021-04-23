package com.geofferyj.panthang.ui.activities

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("SplashActivity", "start")

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
        Log.d("SplashActivity", "Finished")
    }

}