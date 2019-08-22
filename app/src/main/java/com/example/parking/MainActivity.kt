package com.example.parking

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    private var car:Car = Car("A","B","C")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val parking1 = findViewById<TextView>(R.id.parking1_text)
        val parking2 = findViewById<TextView>(R.id.parking2_text)
        val parking3 = findViewById<TextView>(R.id.parking3_text)
        val updatebutton = findViewById<Button>(R.id.update_button)
        val deletebutton = findViewById<Button>(R.id.delete_button)

            parking1.setOnClickListener{
                show(it)
            }
        parking2.setOnClickListener{
            show(it)
        }
        parking3.setOnClickListener{
            show(it)
        }
//        updatebutton.setOnClickListener{
//            updateCar()
//        }

    }
//

    private fun show(view: View){
        val parking1 = findViewById<TextView>(R.id.parking1_text)
        val parking2 = findViewById<TextView>(R.id.parking2_text)
        val parking3 = findViewById<TextView>(R.id.parking3_text)
    val license = findViewById<EditText>(R.id.license_edit_text)
    val carbrand = findViewById<EditText>(R.id.car_brand_edit_text)
    val ownername = findViewById<EditText>(R.id.name_edit_text)
    val updatebutton = findViewById<Button>(R.id.update_button)
    val deletebutton = findViewById<Button>(R.id.delete_button)
        license.visibility = View.VISIBLE
        //license.setText(view.id.toString() +" &"+ parking1.id.toString()  )
        carbrand.visibility = View.VISIBLE
        ownername.visibility = View.VISIBLE
        updatebutton.visibility = View.VISIBLE
        deletebutton.visibility = View.VISIBLE
    if(view.id.equals(parking1.id)){
        updatebutton.setOnClickListener{
            updateCar(parking1)
        }
        deletebutton.setOnClickListener{
            delete(parking1)
        }
    }else if(view.id.equals(parking2.id)){
        updatebutton.setOnClickListener{
            updateCar(parking2)
        }
        deletebutton.setOnClickListener{
            delete(parking2)
        }
    }else{
        updatebutton.setOnClickListener{
            updateCar(parking3)
        }
        deletebutton.setOnClickListener{
            delete(parking3)
        }
    }


}
    private fun updateCar(view: TextView){
        val license = findViewById<EditText>(R.id.license_edit_text)
        var carbrand = findViewById<EditText>(R.id.car_brand_edit_text)
        var ownername = findViewById<EditText>(R.id.name_edit_text)
        val parking1 = findViewById<TextView>(R.id.parking1_text)
        val updatebutton = findViewById<Button>(R.id.update_button)
        val deletebutton = findViewById<Button>(R.id.delete_button)


        car?.License = license.text.toString()
        car?.CarBrand = carbrand.text.toString()
        car?.name = ownername.text.toString()
//        var brand = car?.CarBrand
//        var name = car?.name
        //li = license.text.toString()


        license.visibility = View.GONE
        carbrand.visibility = View.GONE
        ownername.visibility = View.GONE
        updatebutton.visibility = View.GONE
        deletebutton.visibility = View.GONE
        view.setBackgroundColor(Color.RED)
        view.setText(" Plate : ${car.License}  ")



}
    private fun delete(view: TextView){
        val license = findViewById<EditText>(R.id.license_edit_text)
        var carbrand = findViewById<EditText>(R.id.car_brand_edit_text)
        var ownername = findViewById<EditText>(R.id.name_edit_text)

        val updatebutton = findViewById<Button>(R.id.update_button)
        val deletebutton = findViewById<Button>(R.id.delete_button)
        view.setBackgroundResource(R.color.holo_blue_dark)
        license.visibility = View.GONE
        carbrand.visibility = View.GONE
        ownername.visibility = View.GONE
        updatebutton.visibility = View.GONE
        deletebutton.visibility = View.GONE
        view.text = "Empty"
    }

}
