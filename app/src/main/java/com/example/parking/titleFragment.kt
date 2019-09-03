package com.example.parking


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.inflate
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.parking.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 */
class titleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        //val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater,R.layout.fragment_title)
    ): View? {
        // Inflate the layout for this fragment
        //val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater,R.layout.fragment_title)
        val binding: FragmentTitleBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_title, container, false)
        binding.loginButton.setOnClickListener { view ->
            binding.apply {
                var username = usernameEditText.text.toString()
                var password = passwordEditText.text.toString()
                if(username.equals("user") && password.equals("password")){
                    view.findNavController().navigate(R.id.action_titleFragment_to_carParkFragment)
                }else{
                    warningText.text = "Username or Password is not Match!!"
                    warningText.visibility = View.VISIBLE
                }
            }
        }
        setHasOptionsMenu(true)
        return binding.root
        //return inflater.inflate(R.layout.fragment_title, container, false)
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.option_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,view!!.findNavController()) || super.onOptionsItemSelected(item)
    }


}
