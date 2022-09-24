package com.example.weatherapc

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class WindActivity(): AppCompatActivity() {

    private val fabWeatherTempAction: FloatingActionButton by lazy { findViewById(R.id.fabWeatherTempAction) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wind)

        fabWeatherTempAction.setOnClickListener{
            val tempActivityAction = Intent(this, MainActivity::class.java)
            startActivity(tempActivityAction)
        }


    }

}