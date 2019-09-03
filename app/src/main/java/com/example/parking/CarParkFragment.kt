package com.example.parking


import android.graphics.Color
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.parking.databinding.FragmentCarParkBinding

/**
 * A simple [Fragment] subclass.
 */
class CarParkFragment : Fragment() {
    private var car:Car = Car("A","B","C")
    private lateinit var binding: FragmentCarParkBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_car_park,container,false)
        binding.apply {
            parking1Text.setOnClickListener{
                show(it)
            }
            parking2Text.setOnClickListener{
                show(it)
            }
            parking3Text.setOnClickListener {
                show(it)
            }
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.option_menu,menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,view!!.findNavController()) || super.onOptionsItemSelected(item)
    }
    private fun show(view: View){
        binding.apply{
            showview()
            if(view.id.equals(parking1Text.id)){
                updateButton.setOnClickListener {
                    updateCar(parking1Text)
                }
                deleteButton.setOnClickListener {
                    delete(parking1Text)
                }
            }else if(view.id.equals(parking2Text.id)){
                updateButton.setOnClickListener {
                    updateCar(parking2Text)
                }
                deleteButton.setOnClickListener {
                    delete(parking2Text)
                }
            }else{
                updateButton.setOnClickListener {
                    updateCar(parking3Text)
                }
                deleteButton.setOnClickListener {
                    delete(parking3Text)
                }
            }
        }
    }

    private fun updateCar(view: TextView){
        binding.apply {
            car?.License = licenseEditText.text.toString()
            car?.CarBrand = carBrandEditText.text.toString()
            car?.name = nameEditText.text.toString()
            hideview()
            view.setBackgroundColor(Color.RED)
            view.setText(" Plate : ${car.License}  ")


        }
    }
    private fun delete(view: TextView){
        view.setBackgroundResource(R.color.holo_blue_dark)
        hideview()
        view.text = "Empty"

    }
    private fun showview(){
        binding.apply {
            licenseEditText.visibility = View.VISIBLE
            carBrandEditText.visibility = View.VISIBLE
            nameEditText.visibility = View.VISIBLE
            updateButton.visibility = View.VISIBLE
            deleteButton.visibility = View.VISIBLE
        }
    }
    private fun hideview(){
        binding.apply {
            licenseEditText.visibility = View.GONE
            carBrandEditText.visibility = View.GONE
            nameEditText.visibility = View.GONE
            updateButton.visibility = View.GONE
            deleteButton.visibility = View.GONE
        }
    }


}
