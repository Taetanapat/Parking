package com.example.parking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun showEditText(view: View){
        val licenseEditText = findViewById<EditText>(R.id.license_edit_text)
        when (view.id) {
            R.id.parking1_text -> licenseEditText.visibility = View.GONE
        }

    }
    fun setListeners(){
        val parking1 = findViewById<TextView>(R.id.parking1_text)
        val parking2 = findViewById<TextView>(R.id.parking2_text)
        val parking3 = findViewById<TextView>(R.id.parking3_text)
        val clickableViews: List<View> =
            listOf(parking1, parking2, parking3)
    for (item in clickableViews) {
        item.setOnClickListener { showEditText(it) }
    }
    }

}
