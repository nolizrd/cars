package com.example.car

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Установите изображение кота
        val ivCat = findViewById<ImageView>(R.id.picture)
        val catResourceId = resources.getIdentifier("squarecat", "drawable", packageName)
        ivCat.setImageResource(catResourceId)
    }

    fun onChangePictureClick(v: View) {
        // Открываем CarActivity при нажатии кнопки
        val intent = Intent(this, CarActivity::class.java)
        startActivity(intent)
    }
}
