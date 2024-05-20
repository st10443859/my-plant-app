package com.kayise.plantapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge

class MainActivity : AppCompatActivity() {

    //variables

    private var health = 100
    private var water = 0
    private var sunlight = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)



        //buttons
        val buttonWater = findViewById<Button>(R.id.buttonWater)
        val buttonFertilize = findViewById<Button>(R.id.buttonFertilize)
        val buttonSun = findViewById<Button>(R.id.buttonSun)



        updateUI()

        buttonWater.setOnClickListener {

            waterPlant()
            updateUI()
        }

        buttonFertilize.setOnClickListener {

            fertilizePlant()
            updateUI()
        }

        buttonSun.setOnClickListener {

            putPlantInSun()
            updateUI()
        }
    }

    //methods
    private fun waterPlant() {
        sunlight -= 5
        if (water < 0) water = 0
        if (water < 100) water += 10
    }

    private fun fertilizePlant() {
        health = 100
    }

    private fun putPlantInSun() {

        health -= 10
        if (health > 100) health = 100
        sunlight += 10
        if (water > 100) water = 100
        water -= 5
        if (sunlight < 0) sunlight = 0
    }

    private fun updateUI() {
        val textViewHealth = findViewById<TextView>(R.id.textViewHealth)
        val textViewHunger = findViewById<TextView>(R.id.textViewWater)
        val textViewCleanliness = findViewById<TextView>(R.id.textViewSun)

        textViewHealth.text = "Health: $health"
        textViewHunger.text = "Water: $water"
        textViewCleanliness.text = "Sun: $sunlight"
    }


}