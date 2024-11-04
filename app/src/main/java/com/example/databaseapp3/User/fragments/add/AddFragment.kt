package com.example.databaseapp3.User.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.databaseapp3.R
import com.example.databaseapp3.model.User
import com.example.databaseapp3.viewModel.UserViewModel

class AddFragment : Fragment() {

    private lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]


        view.findViewById<Button>(R.id.add_btn).setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val fname = view?.findViewById<EditText>(R.id.fname_et)?.text.toString()
        val lname = view?.findViewById<EditText>(R.id.lname_et)?.text.toString()
        val age = view?.findViewById<EditText>(R.id.age_et)?.text

        if (inputCheck(fname, lname, age)) {
            // create object
            val user = User(0, fname, lname, Integer.parseInt(age.toString()))
            // add to db
            userViewModel.addUser(user)
            Toast.makeText(requireContext(), "Successfully added", Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Fill out all fields", Toast.LENGTH_LONG).show()
        }

    }

    private fun inputCheck(fname: String, lName: String, age: Editable?): Boolean {
        if (age != null) {
            return !(TextUtils.isEmpty(fname) && TextUtils.isEmpty(lName ) && age.isEmpty())
        }
        return false
    }

}