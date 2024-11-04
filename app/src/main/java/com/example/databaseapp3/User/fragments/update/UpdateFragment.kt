package com.example.databaseapp3.User.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.databaseapp3.R
import com.example.databaseapp3.model.User
import com.example.databaseapp3.viewModel.UserViewModel

class UpdateFragment : Fragment() {

    // broke in video
//    private val args by navArgs<UpdateFragmentArgs>()

    lateinit var userViewModel: UserViewModel



    var userId: Int? = null
    lateinit var firstName: String
    lateinit var lastName: String
    var age: Int? = null
    lateinit var currentItem: User

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        // get from bundle
        userId = arguments?.getInt("id")
        firstName = arguments?.getString("firstName")!!
        lastName = arguments?.getString("lastName")!!
        age = arguments?.getInt("age")
        currentItem = arguments?.getParcelable<User>("currentItem")!!

//        val message = "ID: ${userId}, First Name: ${firstName}, Last Name: ${lastName}, Age: ${age}"
//        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()

        view.findViewById<TextView>(R.id.update_fname_et).text = firstName
        view.findViewById<TextView>(R.id.update_lname_et).text = lastName
        view.findViewById<TextView>(R.id.update_age_et).text = age.toString()

        view.findViewById<Button>(R.id.update_btn).setOnClickListener {
            updateItem()
        }

        view.findViewById<Button>(R.id.delete_btn).setOnClickListener {
            deleteUser()
        }


        return view
    }

    private fun deleteUser() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            // delete the user
            userViewModel.deleteUser(currentItem)

            Toast.makeText(requireContext(), "Successfully removed ${firstName}", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }

        builder.setNegativeButton("No") {_, _ -> // do nothin
        }
        builder.setTitle("Delete ${firstName}?")
        builder.setMessage("Are you sure you want to delete ${firstName}")
        builder.show()


    }

    private fun updateItem() {
        val fname = view?.findViewById<EditText>(R.id.update_fname_et)?.text.toString()
        val lname = view?.findViewById<EditText>(R.id.update_lname_et)?.text.toString()
        val age = view?.findViewById<EditText>(R.id.update_age_et)?.text

        if (inputCheck(fname, lname, age)) {
            val updatedUser = User(userId!!, fname, lname, age.toString().toInt())

            //upfate it
            userViewModel.updateUser(updatedUser)

            Toast.makeText(requireContext(), "Updated Successfully", Toast.LENGTH_LONG).show()

            // nav back
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Update request failed.]", Toast.LENGTH_LONG).show()
        }

    }

    private fun inputCheck(fname: String, lName: String, age: Editable?): Boolean {
        if (age != null) {
            return !(TextUtils.isEmpty(fname) && TextUtils.isEmpty(lName ) && age.isEmpty())
        }
        return false
    }

}