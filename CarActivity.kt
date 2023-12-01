package com.example.car

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast

class CarActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener
{
    lateinit var adapter: ArrayAdapter<CharSequence>

    private var pictures = arrayOf("car 1", "car 2", "car 3")

    var currentImageIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car) // Замените на ваш макет для CarActivity

        pictures = resources.getStringArray(R.array.pictures)
        adapter = ArrayAdapter(this, R.layout.item, pictures)
        val spinner = findViewById<Spinner>(R.id.pictures_list)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = this
    }

    fun onChangePictureClick(v: View) {
        val iv = findViewById<ImageView>(R.id.picture)
        // Change picture to the next one in the array
        currentImageIndex = (currentImageIndex + 1) % pictures.size
        val imageName = pictures[currentImageIndex]
        val resourceId = resources.getIdentifier(imageName.replace(" ", ""), "drawable", packageName)
        iv.setImageResource(resourceId)

        // Update spinner selection based on the current image index
        val spinner = findViewById<Spinner>(R.id.pictures_list)
        spinner.setSelection(currentImageIndex)
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        currentImageIndex = position
        val iv = findViewById<ImageView>(R.id.picture)
        val imageName = pictures[currentImageIndex]
        val resourceId = resources.getIdentifier(imageName.replace(" ", ""), "drawable", packageName)
        iv.setImageResource(resourceId)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Toast.makeText(this, "Не выбран элемент", Toast.LENGTH_SHORT).show()
    }
}
